import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int dp[] = new int[K+1];
		dp[0] = 1;
		for(int i=0;i<N;i++) {
			for(int k=1;k<=K;k++) {
				if(k>=arr[i]) {
					dp[k] = dp[k]+dp[k-arr[i]];
				}
			}
		}
		System.out.println(dp[K]);
	}
}