import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int arr[][];
	static boolean visit[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		int before=0;
		while(true) {
			visit = new boolean[N][M];
			int cnt = oneCnt();
			if(cnt ==0) {
				//출략문
				System.out.println(time);
				System.out.println(before);
				return;
			}
			before = cnt;
			time++;
			bfs();
		}
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(0,0));
		visit[0][0] = true;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<M&&!visit[cy][cx]) {
					if(arr[cy][cx]==0) {
						visit[cy][cx] = true;
						mq.add(new Node(cy,cx));
					}else if(arr[cy][cx]==1) {
						visit[cy][cx] = true;
						arr[cy][cx] =9;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]==9) {
					arr[i][k] =0;
				}
			}
		}
	}
	private static int oneCnt() {
		// TODO Auto-generated method stub
		int one = 0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arr[i][k]==1) {
					one++;
				}
			}
		}
		return one;
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
