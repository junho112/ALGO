
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int N,M,R;
	static int arr[][];
	static int time = 0;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				if(str.charAt(k)=='O') {
					arr[i][k] = 1;
				}else {
					arr[i][k] = 0;
				}
			}
		}
		/*
		 * 1. 초기값                         1  
		 * 2. 1초 기다림                   2
		 * 3. 1초 모든 칸 폭탄 설치    3 1
		 * 4. 초기값 펑 (사방펑)   4 2
		 * 5.                  3
		 */
	
		spendTime();
		if(time==R) {
			print();
			return;
		}
		setting();
		if(time==R) {
			print();
			return;
		}
		bomb();
		if(time==R) {
			print();
			return;
		}
		time =-1;
		R = R%4;

		
		while(time<=R) {
			if(time==R) {
				break;
			}
			setting();
//			print();
			if(time==R) {
				break;
			}
			bomb();
//			print();
			if(time==R) {
				break;
			}
		}
		
		print();
	}
	
	
	
	
	private static void print() {
		// TODO Auto-generated method stub
//		System.out.println(time);
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]>=1) {
					System.out.print("O");
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
	private static void bomb() {
		// TODO Auto-generated method stub
		spendTime();
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]==4) {
					for(int j=0;j<4;j++) {
						int cy = dy[j]+i;
						int cx = dx[j]+k;
						if(cy>=0&&cx>=0&&cy<N&&cx<M) {
							if(arr[cy][cx]!=4) {
								arr[cy][cx]=0;
							}
						}
					}
					arr[i][k] = 0;
				}
			}
		}
	}
	private static void setting() {
		 	
		// TODO Auto-generated method stub
		spendTime();
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]==0) {
					arr[i][k]=1;
				}
			}
		}
	}
	private static void spendTime() {
		// TODO Auto-generated method stub
		time++;
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]>=1) {
					arr[i][k]++;
				}
			}
		}
	}
}
/*
2 2 5
O.
.O
*/
