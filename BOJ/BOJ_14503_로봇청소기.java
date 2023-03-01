import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기{
	static int dx[] = {-1,0,1,0}; //북동남서
	static int dy[] = {0,1,0,-1};
	static int N,M;
	static int arr[][];
	static int result = 1;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(x,y,d); // y좌표 x좌표 d방향


		System.out.println(result);
	}
	private static void dfs(int x, int y, int d) {
		// TODO Auto-generated method stub
		arr[x][y] = 2; //2가 청소의 의미 
		int d1 = d;
		for(int i=0;i<4;i++) {
			d1 = (d1+3)%4;
//			d -= 1;
//			if(d==-1) d = 3;
			int nx = x+dx[d1];
			int ny = y+dy[d1];
			if(arr[nx][ny]==0) { //여기가 청소 안한 칸이네! 
				result++;
				dfs(nx,ny,d1); //다른곳 청소하자 
				
				return;
			}
		}
		//빈칸이 없어서 청소못함
		//뒤로 백해야댐
		int back = (d+2)%4;
		int by = y+dy[back];
		int bx = x+dx[back];
		if(arr[bx][by]!=1) {
			dfs(bx,by,d);
		}
	}
}
