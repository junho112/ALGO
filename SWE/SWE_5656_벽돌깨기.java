
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWE_5656_벽돌깨기{
	/*
	 * 1. 조합 생성
	 * 2. 벽돌깨기 
	 */
	static int num;
	static int M,N;
	static int arr[][];
	static int arrC[][];
	static int result[];
	static int realresult = Integer.MAX_VALUE;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());  // 조합 
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			arrC = new int[N][M];
			result = new int[num];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			back(0);
			sb.append("#").append(test).append(" ").append(realresult).append("\n");
//			System.out.println("#"+test+" "+realresult);
			realresult = Integer.MAX_VALUE;
		}
		System.out.println(sb);
		
		
	}
	private static void back(int def) {
		// TODO Auto-generated method stub
		if(def==num) {
			//연산
			
			for(int i=0;i<N;i++) {
				for(int k=0;k<M;k++) {
					arrC[i][k] = arr[i][k];
				}
			}

			for(int i=0;i<num;i++) {
				boolean flag = false;
				int x = result[i];
				for(int k=0;k<N;k++) {
					if(arrC[k][x]!=0&&!flag) {
						dfs(k,x,arrC[k][x]-1);
						down();
//						print();

						flag = true;
					}
				}
			}

			int re = count();
//			System.out.println(re);
			realresult = Math.min(re,realresult);
			return;
		}
		for(int i=0;i<M;i++) {
			result[def] = i;
			back(def+1);
		}
	}

	private static int count() {
		// TODO Auto-generated method stub
		int tmp = 0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arrC[i][k]!=0) {
					tmp++;
				}
			}
		}
		return tmp;
	}
	private static void down() {
		// TODO Auto-generated method stub
		for(int i=0;i<M;i++) {
			Stack<Integer> st = new Stack<>();
			for(int k=0;k<N;k++) {
				if(arrC[k][i]!=0) {
					st.add(arrC[k][i]);
					arrC[k][i] = 0;
				}
			}
			int n =N-1;
			while(!st.empty()) {
				int tmp = st.pop();
				arrC[n][i] = tmp;
				n--;
			}
		}
	}
	private static void dfs(int y, int x, int def) {
		// TODO Auto-generated method stub
		arrC[y][x] = 0;
		

		if(def==0) {
			return;
		}
		
		for(int i=1;i<=def;i++) {
			for(int k=0;k<4;k++) {
				int cy = y+dy[k]*i;
				int cx = x+dx[k]*i;
//				System.out.println(cy+" "+cx);

				if(cy>=0&&cx>=0&&cy<N&&cx<M) {
					if(arrC[cy][cx]!=0) {
						dfs(cy,cx,arrC[cy][cx]-1);
					}
				}
			}
		}
	}
	private static void print() {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				System.out.print(arrC[i][k]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}


