import java.util.Scanner;

public class Main{
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		int dp[] = new int[N+1];
		dp[0] =0; dp[1] = arr[1];
		
		for(int i=2;i<=N;i++) {
			for(int k=1;k<i;k++) {
				dp[i] = Math.max(dp[i],dp[i-k]+arr[k]);
			}
			dp[i] = Math.max(dp[i], arr[i]);
		}
		System.out.println(dp[N]);
	}
}