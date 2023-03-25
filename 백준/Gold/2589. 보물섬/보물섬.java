import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int arr[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static Queue<int[]> mq = new ArrayDeque<>();
	static int realresult;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int k=0;k<M;k++) {
				if(tmp.charAt(k)=='W') {
					arr[i][k] = 0;  //물
				}else {
					arr[i][k] = 1;  //땅
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]==1) {
					int visit[][] = new int[N][M];
					visit[i][k] = 1;
					mq.add(new int[] {i,k});
					bfs(visit);
				}
			}
		}
		System.out.println(realresult-1);
	}
	private static void bfs(int[][] visit) {
		int result = 1;
		// TODO Auto-generated method stub
		while(!mq.isEmpty()) {
			int[] tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp[0] + dy[i];
				int cx = tmp[1] + dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<M&&arr[cy][cx]==1&&visit[cy][cx]==0) {
					visit[cy][cx] = visit[tmp[0]][tmp[1]]+1; 
					result = Math.max(visit[cy][cx], result);
					mq.add(new int[] {cy,cx});
				}
			}
		}
		
		realresult = Math.max(realresult, result);
		
	}

}
