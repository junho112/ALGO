import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int wei[] = new int[N + 1];
		int pro[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			wei[i] = Integer.parseInt(st.nextToken());
			pro[i] = Integer.parseInt(st.nextToken());
		}
		int dp[][] = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) { // 물건
			for (int k = 1; k <= M; k++) { // 무게
				if (wei[i] > k) {
					dp[i][k] = dp[i - 1][k];
				} else {
					dp[i][k] = Math.max(dp[i - 1][k], pro[i] + dp[i - 1][k - wei[i]]);
				}
			}
		}

		System.out.println(dp[N][M]);

	}
}
