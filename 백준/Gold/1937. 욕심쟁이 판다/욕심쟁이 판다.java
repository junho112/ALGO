import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static int dp[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}


		int result = 0;

		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				int tmp = dfs(i,k);
				result = Math.max(tmp, result);
			}
		}
		

		System.out.println(result);
	}
	

	private static int dfs(int y, int x) {
		// TODO Auto-generated method stub
		if(dp[y][x]!=0) {
			return dp[y][x];
		}
		dp[y][x] =1;
		for(int i=0;i<4;i++) {
			int cy = dy[i]+y;
			int cx = dx[i]+x;
			if(cy>=0&&cx>=0&&cy<N&&cx<N) {
				if(arr[y][x]<arr[cy][cx]) {
					dp[y][x] = Math.max(dp[y][x], dfs(cy,cx)+1);
				}
			}
		}
		return dp[y][x];
	}















	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
