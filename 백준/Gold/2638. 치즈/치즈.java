import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static int arr[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int visit[][];
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while(isZero()) {
			visit = new int[N][M];
			time++;
			bfs();
		}
		System.out.println(time);
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		int tmpA [][] = new int[N][M];
		mq.add(new Node(0,0));
		visit[0][0] = -1;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<M&&visit[cy][cx]>=0) {
					if(arr[cy][cx]==0) {
						mq.add(new Node(cy,cx));
						visit[cy][cx] = -1;
					}
					else if(arr[cy][cx]==1) {
						visit[cy][cx]++;
					}
				}
			}
		}
//		print(visit);
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(visit[i][k]>=2) {
					arr[i][k] = 0;
				}
			}
		}
	}
	private static boolean isZero() {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]!=0) {
					return true;
				}
			}
		}
		return false;
	}
	
	static void print(int ar[][]) {
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				System.out.print(ar[i][k]+" ");
			}
			System.out.println();
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