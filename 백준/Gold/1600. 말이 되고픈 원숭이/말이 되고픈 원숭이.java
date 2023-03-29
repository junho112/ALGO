import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dy[] = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dx[] = { 0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int D;
	static int N, M;
	static int arr[][];
	static int visit[][];
	static boolean visited[][][];
	static int result = Integer.MAX_VALUE;

	// 0~3 4~11
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		D = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new int[N][M];
		visited = new boolean[N][M][D + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(0, 0, 0, 0));
		while (!mq.isEmpty()) {
			Node tmp = mq.poll();
//			System.out.println(tmp);
			if ((tmp.y == (N - 1)) && (tmp.x == (M - 1))) {
				result = Math.min(result, tmp.r);
			}
			for (int i = 0; i < 12; i++) {

				int cy = tmp.y + dy[i];
				int cx = tmp.x + dx[i];
				int cd = tmp.d;
				int cr = tmp.r + 1;

				if (cy >= 0 && cx >= 0 && cy < N && cx < M && arr[cy][cx] != 1) {
//					System.out.println(cy + " " + cx + " " + (N - 1) + " " + (M - 1));
					if (i < 4) {
						if (!visited[cy][cx][cd]) {
							visited[cy][cx][cd] = true;
							mq.add(new Node(cy, cx, cd, cr));
						}
					} else if (cd < D) {
						if (!visited[cy][cx][cd + 1]) {
							visited[cy][cx][cd + 1] = true;
							mq.add(new Node(cy, cx, cd + 1, cr));
						}
					}
				}
			}
		}

	}
	/*
	 * 
	 * 1 5 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 1 0
	 */

	static class Node {
		int y;
		int x;
		int d;
		int r;

		public Node(int y, int x, int d, int r) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.r = r;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [y=");
			builder.append(y);
			builder.append(", x=");
			builder.append(x);
			builder.append(", d=");
			builder.append(d);
			builder.append(", r=");
			builder.append(r);
			builder.append("]");
			return builder.toString();
		}

	}

}