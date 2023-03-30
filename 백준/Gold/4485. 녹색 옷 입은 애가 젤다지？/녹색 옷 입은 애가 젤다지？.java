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
	static int result[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testNo = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			arr = new int[N][N];
			result = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				Arrays.fill(result[i], Integer.MAX_VALUE);
			}
			result[0][0] = arr[0][0];
			bfs(0,0);
			sb.append("Problem ").append(testNo).append(": ").append(result[N-1][N-1]);
			sb.append("\n");
			testNo++;
		}
		System.out.println(sb);
	}
	
	
	
	
	private static void bfs(int y, int x) {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(y,x));
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<N) {
					if(result[cy][cx]>result[tmp.y][tmp.x]+arr[cy][cx]) {
						result[cy][cx] = result[tmp.y][tmp.x]+arr[cy][cx];
						mq.add(new Node(cy,cx));
					}
				}
			}
		}
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