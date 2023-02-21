import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int arr[][];
	static int cnt;
	static int dy[] = {0,1,1};
	static int dx[] = {1,0,1};
	public static void main(String[] agrs) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
//		flag = 0;
		if(arr[0][2]==1) {
			System.out.println(cnt);
		}
		else {
			dfs(0,1,0);
			System.out.println(cnt);
		}
	}
	private static void dfs(int y, int x,int flag) {
		// TODO Auto-generated method stub
		if(y==N-1&&x==N-1) {
//			for(int i=0;i<N;i++) {
//				for(int k=0;k<N;k++) {
//					System.out.print(arr[i][k]+" ");
//				}
//				System.out.println();
//			}
			cnt++;
//			System.out.println("가챠");
			return;
		}
		for(int i=0;i<2;i++) {
			if(flag!=2&&flag!=i) {
				continue;
			}
			int cy = y+dy[i];
			int cx = x+dx[i];
			if(cy>=0&&cx>=0&&cy<N&&cx<N&&arr[cy][cx]==0) {
//				flag = i;
				arr[cy][cx] = 1;
				dfs(cy,cx,i);
				arr[cy][cx] = 0;
			}
		}
		int cy = y+dy[2];
		int cx = x+dx[2];
		if(cy>=0&&cx>=0&&cy<N&&cx<N&&arr[cy][cx]==0&&arr[cy-1][cx]==0&&arr[cy][cx-1]==0) {
//			flag = 2;
			arr[cy][cx] = 1;
			arr[cy][cx-1] = 1;
			arr[cy-1][cx] = 1;
			dfs(cy,cx,2);
			arr[cy][cx] = 0;
			arr[cy][cx-1] = 0;
			arr[cy-1][cx] = 0;
		}
	}
}
