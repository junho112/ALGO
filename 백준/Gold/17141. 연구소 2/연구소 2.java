import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 0-> 빈칸 1 -> 벽 2 -> 바이러스 
	static int N,M;
	static int arr[][];
	static Location result[];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int real = Integer.MAX_VALUE;
	static List<Location> list = new ArrayList<>();
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		result = new Location[M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if(arr[i][k]==2) {
					list.add(new Location(i,k));
					arr[i][k] = 0;
				}
			}
		}
		back(0,0);
		if(real == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(real-2);
		}
	}
	
	private static void back(int def, int start) {
		// TODO Auto-generated method stub
		if(def==M) {
			bfs();
			return;
		}
		for(int i=start;i<list.size();i++) {
			result[def] = list.get(i);
			back(def+1,i+1);
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Location> mq = new ArrayDeque<>();
		int [][] arrC = arrayCopy();
		for(int i=0;i<M;i++) {
			mq.add(result[i]);
			arrC[result[i].y][result[i].x] = 2;
		}
		while(!mq.isEmpty()) {
			Location tmp = mq.poll();
			for(int i=0;i<4;i++) {
				int cy = tmp.y+dy[i];
				int cx = tmp.x+dx[i];
				if(cy>=0&&cx>=0&&cy<N&&cx<N&&arrC[cy][cx]==0) {
					arrC[cy][cx] = arrC[tmp.y][tmp.x]+1;
					mq.add(new Location(cy,cx));
				}
			}
		}
//		print(arrC);
		int sum = 0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				sum = Math.max(sum, arrC[i][k]);
				if(arrC[i][k]==0) {
					sum = Integer.MAX_VALUE;
				}
			}
		}
//		System.out.println(sum);
		real = Math.min(sum, real);
	}






	private static void print(int[][] arrC) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				System.out.print(arrC[i][k]+" ");
			}
			System.out.println();
		}
	}

	private static int[][] arrayCopy() {
		// TODO Auto-generated method stub
		int arrC[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				arrC[i][k] = arr[i][k];
			}
		}
		return arrC;
	}






	static class Location{
		int y;
		int x;
		public Location(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
