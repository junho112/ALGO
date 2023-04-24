import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static char[][] arr;
	static int endy,endx,starty,startx;
	static int visit[][];
	static char[][] result;
	static int num;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		arr = new char[N][M];
		result = new char[N][M];
		visit = new int[N][M];
		startx = 0;
		starty = 0;
		endx = 0;
		endy = 0;
		boolean flag = true;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = str.charAt(k);
				if(i==0||k==0||i==N-1||k==M-1) {
					if(arr[i][k]=='.'&&flag) {
						starty = i;
						startx = k;
						flag = false;
					}else if(arr[i][k]=='.'&&!flag) {
						endy = i;
						endx = k;
					}
				}
			}
		}
		bfs(starty,startx);
		result[endy][endx] = '.'; 
		result[starty][startx] = '.'; 
		bfs2(endy,endx);
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(result[i][k]=='.') {
					sb.append('.');
//					System.out.print('.');
				}else if(arr[i][k]=='.') {
//					System.out.print('@');
					sb.append('@');
				}else if(arr[i][k]=='+') {
//					System.out.print('+');
					sb.append('+');
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs2(int endy2, int endx2) {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(endy,endx,num));
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			if(tmp.y==starty&&tmp.x==startx) {
				return;
			}
			for(int i=0;i<4;i++) {
				int cy = dy[i] +tmp.y;
				int cx = dx[i] +tmp.x;
				if(cy>=0&&cx>=0&&cy<N&&cx<M) {
					if(visit[cy][cx]==tmp.cnt-1) {
						result[cy][cx] = '.';
						mq.add(new Node(cy,cx,tmp.cnt-1));
						continue;
					}
				}
			}
		}
	}

	private static void bfs(int starty, int startx) {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(starty,startx,1)); // 1부터 시작
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			if(tmp.y==endy&&tmp.x==endx) {
				num=tmp.cnt;
				return;
			}
			for(int i=0;i<4;i++) {
				int cy = dy[i] +tmp.y;
				int cx = dx[i] +tmp.x;
				if(cy>=0&&cx>=0&&cy<N&&cx<M) {
					if(arr[cy][cx]=='.'&&visit[cy][cx]==0) {
						visit[cy][cx] = tmp.cnt+1;
						mq.add(new Node(cy,cx,tmp.cnt+1));
					}
				}
			}
		}
	}










	static class Node{
		int y;
		int x;
		int cnt;
		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		
	}
}