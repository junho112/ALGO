
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		long dp[] = new long[1000001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a <= 3) {
				sb.append(dp[a] + "\n");
			} else {
				for (int k = 4; k <= a; k++) {
					dp[k] = ((dp[k - 1] + dp[k - 2]) % 1000000009 + dp[k - 3]) % 1000000009;
				}
				sb.append(dp[a] + "\n");
			}
		}
		System.out.println(sb);

	}
}
