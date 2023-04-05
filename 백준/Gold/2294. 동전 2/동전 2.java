import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int dp[] = new int[1000000];
		Arrays.fill(dp, 100000000);
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[arr[i]] = 1;
		}
		
		for(int i=0;i<N;i++) {
			for(int k=1;k<=K;k++) {
				if(k>=arr[i]) {
					dp[k] = Math.min(dp[k], dp[k-arr[i]]+1);
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		if(dp[K]==100000000) {
			System.out.println(-1);
		}else {
			System.out.println(dp[K]);
		}
	}
}