import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[];
	static int result[];
	static int realresult = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N];
		result = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		back(0);
		System.out.println(realresult);
	}

	private static void back(int def) {
		// TODO Auto-generated method stub
		if (def == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				if (arr[result[i]][result[i + 1]] == 0) {
					return;
				} else {
					sum += arr[result[i]][result[i + 1]];
				}
			}
			if (arr[result[N - 1]][result[0]] == 0) {
				return;
			} else {
				sum += arr[result[N - 1]][result[0]];
			}
			realresult = Math.min(realresult, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				result[def] = i;
				visit[i] = true;
				back(def + 1);
				visit[i] = false;
			}
		}
	}
}