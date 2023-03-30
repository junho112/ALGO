import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 1. 벽의 3개 조합 만들기 2. bfs돌리기 3. 0의 갯수 세기 (최댓값 비교)
	 */
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int N, M;
	static int arr[][];
	static List<Node> list = new ArrayList<>();
	static List<Node> virus = new ArrayList<>();
	static Node[] wall = new Node[3];
	static int realresult = Integer.MIN_VALUE;

	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if (arr[i][k] == 0) {
					list.add(new Node(i, k));
				} else if (arr[i][k] == 2) {
					virus.add(new Node(i, k));
				}
			}
		}
		dfs(0, 0);
		System.out.println(realresult);
	}

	private static void dfs(int def, int start) {
		// TODO Auto-generated method stub
		if (def == 3) {
			// 배열복사 -> 벽만들기 -> bfs
			int copy[][] = arrC(arr);
			for (int i = 0; i < 3; i++) {
				copy[wall[i].y][wall[i].x] = 1;
			}
			Queue<Node> mq = new ArrayDeque<>();
			for (int i = 0; i < virus.size(); i++) {
				mq.add(virus.get(i));
			}
			int re  =  bfs(mq,copy);
			realresult = Math.max(re, realresult);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			wall[def] = list.get(i);
			dfs(def + 1, i + 1);
		}
	}

	// 0의 갯수 살리기
	private static int bfs(Queue<Node> mq, int[][] arrC) {
		// TODO Auto-generated method stub
		while (!mq.isEmpty()) {
			Node tmp = mq.poll();
			for (int i = 0; i < 4; i++) {
				int cy = tmp.y + dy[i];
				int cx = tmp.x + dx[i];
				if (cy >= 0 && cx >= 0 && cy < N && cx < M) {
					if(arrC[cy][cx]==0) {
						arrC[cy][cx] = 9;
						mq.add(new Node(cy,cx));
					}
				}
			}
		}
		int result = 0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				if(arrC[i][k]==0) {
					result++;
				}
			}
		}
		return result;
	}

	// 배열복사
	private static int[][] arrC(int[][] arr2) {
		// TODO Auto-generated method stub
		int copy[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < M; k++) {
				copy[i][k] = arr[i][k];
			}
		}
		return copy;
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}