import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {
	static int dy[] = {-1,1,0,0};//상하좌우
	static int dx[] = {0,0,-1,1};
	static int map[][]; 
	static int stu[][];
	static int N;
	static List<int []> location = new ArrayList<>();
	static List<int []> location2 = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int arr[][] = new int[N*N][5];
		stu = new int[N*N+1][5]; //학생 정보 잘 파악 
		// 0 -> 자기 번호 1~4 -> 좋아하는 사람 번호 
		StringTokenizer st;
		for(int i=0;i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<5;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				stu[arr[i][0]][k] = arr[i][k];
			}
		}
		//첫번 째 아이는 고정임 
		
		for(int i=0;i<N*N-1;i++) {
			//학생 자리 저장 
			sitDown(arr[i][0]);
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(map[i][k]==0) {
					map[i][k] = arr[N*N-1][0];
				}
			}
		}
		// 점수 계산
		int realresult = 0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				int tmp = 0;
				int cy = 0;
				int cx = 0;
				for(int j=0;j<4;j++) {
					cy = i+dy[j];
					cx = k+dx[j];
					if(cy>=0&&cx>=0&&cy<N&&cx<N) {
						for(int z=1;z<5;z++) {
							if(map[cy][cx]==stu[map[i][k]][z]) {
								tmp++;
							}
						}
					}
				}
				if(tmp==0) {
					continue;
				}else if(tmp==1) {
					realresult=realresult+1;
				}else if(tmp==2) {
					realresult=realresult+10;
				}else if(tmp==3) {
					realresult=realresult+100;
				}else if(tmp==4) {
					realresult=realresult+1000;
				}
			}
		}
		System.out.println(realresult);
		
		//디버깅용ㅇㅇ
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<N;k++){
//				System.out.print(map[i][k]+" ");
//			}
//			System.out.println();
//		}
//		//
		
	}
	private static void sitDown(int num) {
		// TODO Auto-generated method stub
		//좋아하는 학생이 인접한 칸에 가장 많은 칸 
		location.clear();
		int result = 0;
		int cy=0;
		int cx=0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				int tmp =0;
				if(map[i][k]!=0) {
					continue;
				}
				for(int j=0;j<4;j++) {
					cy = dy[j]+i;
					cx = dx[j]+k;
					if(cy>=0&&cx>=0&cy<N&&cx<N) {
						for(int x=1;x<5;x++) {
							if(map[cy][cx]==stu[num][x]) {
								tmp++;
							}
						}
					}
				}
				if(result<tmp) {
					result = tmp;
					location.clear();
					location.add(new int[] {i,k});
				}else if(result==tmp) {
					location.add(new int[] {i,k});
				}
			}
		}
		if(location.size()==1) {
			map[location.get(0)[0]][location.get(0)[1]] = num;
		}else {
			sitDown2(num);
		}
	}
	
	
	private static void sitDown2(int num) {
		// TODO Auto-generated method stub
		// 비어있는 칸이 가장 많은 곳 
		int cy = 0;
		int cx = 0;
		int result = 0;
		location2.clear();
		for(int i=0;i<location.size();i++){
			int tmp = 0;
			for(int k=0;k<4;k++) {
				cy = dy[k]+location.get(i)[0];
				cx = dx[k]+location.get(i)[1];			
				if(cy>=0&&cx>=0&&cy<N&&cx<N) {
					if(map[cy][cx]==0) {
						tmp++;
					}
				}
			}
//			for(int z=0;z<N;z++) {
//				for(int v=0;v<N;v++){
//					System.out.print(map[z][v]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(num+" "+tmp+" "+location.get(i)[0]+" "+location.get(i)[1]);
			if(result<tmp) {
				location2.clear();
				result = tmp;
				location2.add(new int[] {location.get(i)[0],location.get(i)[1]});
			}else if(result == tmp) {
				location2.add(new int[] {location.get(i)[0],location.get(i)[1]});
			}
			
		}
		map[location2.get(0)[0]][location2.get(0)[1]] = num;
	}

}
