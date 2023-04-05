import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	/*
	 * . -> 비어 있음 0
	 * * -> 물 1
	 * X -> 돌  -1
	 * D -> 도착 endy endx
	 * S -> 시작 starty startx
	 */
	static int N,M;
	static int arr[][];
	static int visit[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new int[N][M];
		arr = new int[N][M];
		int starty = 0;
		int startx = 0;
		int endy = 0;
		int endx = 0;
		Queue<Node> mq = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				if(str.charAt(k)=='.') {
					arr[i][k] = 0;
				}else if(str.charAt(k)=='*') {
					arr[i][k] = 1;
					mq.add(new Node(i,k));
				}else if(str.charAt(k)=='D') {
					endy = i;endx = k;
				}else if(str.charAt(k)=='S') {
					starty = i;startx = k;
				}else if(str.charAt(k)=='X') {
					arr[i][k] = -1;
				}
			}
		}

		//물 넘치게 하기 
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<M&&arr[cy][cx]==0) {
					if(endy==cy&&endx==cx) continue;
					arr[cy][cx] = arr[tmp.y][tmp.x]+1;
					mq.add(new Node(cy,cx));
				}
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<M;k++) {
//				System.out.print(arr[i][k]+" ");
//			}
//			System.out.println();
//		}
		//이동시키기 
		mq.clear();
		mq.add(new Node(starty,startx));
		visit[starty][startx] = 1;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			if(tmp.y==endy&&tmp.x==endx) {
				System.out.println(visit[tmp.y][tmp.x]-1);
				return;
			}
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<M&&visit[cy][cx]==0) {
					if(visit[tmp.y][tmp.x]+1<arr[cy][cx]||arr[cy][cx]==0) {
						mq.add(new Node(cy,cx));
						visit[cy][cx] = visit[tmp.y][tmp.x]+1;
					}
				}
			}
		}
//		System.out.println();
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<M;k++) {
//				System.out.print(visit[i][k]+" ");
//			}
//			System.out.println();
//		}
		System.out.println("KAKTUS");
		
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