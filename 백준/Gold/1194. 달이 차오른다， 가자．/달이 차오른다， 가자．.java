import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static char arr[][];
	static boolean dp[][][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		dp = new boolean[N][M][1<<6];
		int starty = 0;
		int startx = 0;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = str.charAt(k);
				if(arr[i][k]=='0') {
					starty = i; startx = k;
				}
			}
		}
		int result = bfs(starty,startx);
		System.out.println(result);
		
		
	}
	
	private static int bfs(int starty, int startx) {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(starty,startx,0,0));
		dp[starty][startx][0] = true;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
			if(arr[tmp.y][tmp.x]=='1') {
				return tmp.cnt;
			}
			for(int i=0;i<4;i++) {
				int cy = dy[i] + tmp.y;
				int cx = dx[i] + tmp.x;
				int ckey = tmp.key;
				if(cy<0||cx<0||cy>=N||cx>=M) continue;
				if(arr[cy][cx]=='#') continue;
				if(dp[cy][cx][ckey]) continue;
				//키줍기
				if(arr[cy][cx]>='a'&&arr[cy][cx]<='f') {
					ckey = ckey|(1<<arr[cy][cx]-'a');
				}
				else if(arr[cy][cx]>='A'&&arr[cy][cx]<='F') {
					if((ckey&1<<(arr[cy][cx]-'A'))==0) {
						continue;
					}
				}
				dp[cy][cx][ckey] = true;
				mq.add(new Node(cy,cx,ckey,tmp.cnt+1));
			}
		}
		return -1;
	}










	static class Node{
		int y;
		int x;
		int key;
		int cnt;
		public Node(int y, int x, int key, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.key = key;
			this.cnt = cnt;
		}
	}
}