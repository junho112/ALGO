import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int dy[] = {-1,0,1,0}; 
	static int dx[] = {0,1,0,-1};//상우하좌
	static int N;
	static int M;
	static int arr[][];
	static int map[][];
	static int comb; //카메라 개수
	static int combi[]; //카메라 방향 조합
	static int realresult = Integer.MAX_VALUE;
	static int zero = 0; //영 개수
	static int zeroCopy; //
	static List<int[]> list = new ArrayList<>();
	// 1 2 3 4 5      6 : 벽
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if(arr[i][k]!=0&&arr[i][k]!=6) {
					list.add(new int[] {i,k});
					comb++;
				}
				if(arr[i][k]==0) {
					zero++;
				}
			}
		}
		combi = new int[comb];
		back(0);
		System.out.println(realresult);
	}

	private static void back(int def) {
		// TODO Auto-generated method stub
		if(def == comb) {
			//수행
			CCTV();
//			System.out.println(Arrays.toString(combi));
			return;
		}
		for(int i=0;i<=3;i++) {
			combi[def] = i;
			back(def+1);
		}
	}

	private static void CCTV() {
		// TODO Auto-generated method stub
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			System.arraycopy(arr[i], 0, map[i], 0, M);
		}
		int tmp = 0; //combi 몇번째인짖 
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<M;k++) {
//				if(map[i][k]==1||map[i][k]==2||map[i][k]==3||map[i][k]==4||map[i][k]==5) {
//					check(i,k,map[i][k],tmp);
//					tmp++;
//				}
//					
//			}
//		}
		zeroCopy = zero;
		for(int i=0;i<list.size();i++) {
			check(list.get(i)[0],list.get(i)[1],map[list.get(i)[0]][list.get(i)[1]],tmp);
			tmp++;
		}
//		int result = 0;
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<M;k++) {
//				if(map[i][k] ==0) {
//					result ++;
//				}
//				System.out.print(map[i][k]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(realresult);
		realresult = Math.min(realresult, zeroCopy);
	}

	private static void check(int y, int x,int c, int tmp) {
		// TODO Auto-generated method stub
		if(c==1) {
			//한번
			int tmp1 = combi[tmp]%4;
			cal(tmp1,y,x);
			
		}else if(c==2) {
			int tmp1 = combi[tmp]%4;
			int tmp2 = (combi[tmp]+2)%4;
			cal(tmp1,y,x);
			cal(tmp2,y,x);
			//두번
		}else if(c==3) {
			int tmp1 = combi[tmp]%4;
			int tmp2 = (combi[tmp]+1)%4;
			cal(tmp1,y,x);
			cal(tmp2,y,x);
			//두번
		}else if(c==4) {
			int tmp1 = combi[tmp]%4;
			int tmp2 = (combi[tmp]+1)%4;
			int tmp3 = (combi[tmp]+3)%4;
			cal(tmp1,y,x);
			cal(tmp2,y,x);
			cal(tmp3,y,x);
			//세번
		}else if(c==5) {
			//네번
			int tmp1 = 0;
			int tmp2 = 1;
			int tmp3 = 2;
			int tmp4 = 3;
			cal(tmp1,y,x);
			cal(tmp2,y,x);
			cal(tmp3,y,x);
			cal(tmp4,y,x);
		}
	}

	private static void cal(int tmp1, int y, int x) {
		// TODO Auto-generated method stub
		int cy = y+ dy[tmp1];
		int cx = x+ dx[tmp1];
		boolean flag = true;
		while(flag) {
			if(cy>=0&&cx>=0&&cy<N&&cx<M&&map[cy][cx]!=6) {
				if(map[cy][cx]==0) {
					zeroCopy--;
					map[cy][cx] = 9;
				}
			}else if(cy>=0&&cx>=0&&cy<N&&cx<M&&(map[cy][cx]==1||map[cy][cx]==2||map[cy][cx]==3||map[cy][cx]==4||map[cy][cx]==5||map[cy][cx]==9)) {
				cy = cy+dy[tmp1];
				cx = cx+dx[tmp1];
				continue;
			}else {
				flag = false;
			}
			cy = cy+dy[tmp1];
			cx = cx+dx[tmp1];
		}
	}

}
/*
5 5
0 0 0 0 0
6 2 0 0 4
0 0 0 4 0
5 0 0 5 0
6 0 0 0 0


3



*/
