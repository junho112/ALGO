import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static int dy[] = {-1,1,0,0}; //상 하 좌 우
	static int dx[] = {0,0,-1,1};
	static int N;
	static int M;
	static int[][] arr;
	static int[][] result;
	static boolean[][] visit;
	static int minCnt = Integer.MAX_VALUE;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
		arr = new int[N][M];
		result = new int[N][M];
		for(int i=0;i<N;i++) {
			String a = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = a.charAt(k)-'0';
			}
		}
		bfs(0,0);
//		dfs(0,0,1);
		
		System.out.println(result[N-1][M-1]);
	
}
	
	
	
	
	private static void bfs(int k, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> mq = new ArrayDeque<>();
		mq.add(new int[] {k,j});
		result[k][j] = 1;
		while(!mq.isEmpty()) {
			int y = mq.peek()[0];
			int x = mq.peek()[1];
			mq.poll();
			
			for(int i=0;i<4;i++) {
				int cy = y+dy[i];
				int cx = x+dx[i];
				if(cy>=0&&cy<N&&cx>=0&&cx<M&&arr[cy][cx]==1) {
					if(!visit[cy][cx]) {
						visit[cy][cx] = true;
						mq.add(new int[] {cy,cx});
						result[cy][cx] = result[y][x]+1;
					}
					
				}
			}
		}
	}

//
//
//
//	private static void dfs(int y, int x, int cnt) {
//		// TODO Auto-generated method stub
//		if(y==N-1&&x==M-1) {
//			minCnt = Math.min(cnt, minCnt);
//		}
//		int cy=y;
//		int cx=x;
//		for(int i=0;i<4;i++) {
////			System.out.println(cy+" "+cx);
////			System.out.println(cnt);
//			cy = y+dy[i];
//			cx = x+dx[i];
//			if(cy>=0&&cy<N&&cx>=0&&cx<M&&arr[cy][cx]==1) {
//				if(!visit[cy][cx]) {
//					visit[cy][cx] = true;
//					dfs(cy,cx,cnt+1);
//					visit[cy][cx] = false;
//				}
//				
//			}
//
//		}
//		
//		
//	}
}
