import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static int arr[][];
	static int min = Integer.MAX_VALUE;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		List<Node> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = str.charAt(k)-'0';
			}
		}
		bfs();
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(0,0,1,0));
		boolean visit[][][] = new boolean[N][M][2];
		visit[0][0][0] = true;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			if(tmp.y==N-1&&tmp.x==M-1) {
				min = Math.min(tmp.d, min);
				return;
			}
			for(int i=0;i<4;i++) {
				int cy = dy[i]+tmp.y;
				int cx = dx[i]+tmp.x;
				if(cy>=0&&cx>=0&&cy<N&&cx<M) {
					if(tmp.one==1) {
						if(arr[cy][cx]==0&&!visit[cy][cx][1]) {
							mq.add(new Node(cy,cx,tmp.d+1,1));
							visit[cy][cx][1] = true;
						}
					}else {
						if(arr[cy][cx]==0&&!visit[cy][cx][0]) {
							mq.add(new Node(cy,cx,tmp.d+1,0));
							visit[cy][cx][0] = true;
						}else if(arr[cy][cx]==1&&!visit[cy][cx][1]) {
							mq.add(new Node(cy,cx,tmp.d+1,1));
							visit[cy][cx][1] = true;
						}
					}
				}
			}
		}
	}

	static class Node{
		int y;
		int x;
		int d;
		int one;
		public Node(int y, int x,int d,int one) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.one = one;
		}
		
	}
}