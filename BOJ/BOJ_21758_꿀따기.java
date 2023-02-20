import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		int dp[] = new int[N+1];
		arr[0] = 0; dp[0] = 0;
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			list.add(arr[i]);
			dp[i] = dp[i-1] + arr[i]; //누적합 
		}
		list.add(0);
		Collections.reverse(list);
		int arr2[] = new int[N+1];
		int dp2[] = new int[N+1];
		arr2[0] = 0; dp2[0] = 0;
		
		for(int i=1;i<=N;i++) {
			arr2[i] = list.get(i);
			dp2[i] = arr2[i]+dp2[i-1];
		}
		
		int result = 0;
		for(int i=2;i<N;i++) { //1 출발 2~N-1 출발 N 벌통
			int tmp =0;
			//오른쪽 벌통은 오른쪽 고정???
			tmp = dp[N]-dp[1]-arr[i]+dp[N]-dp[i];
			result = Math.max(result, tmp);
			//중간
			tmp = 0;
			tmp = dp[i]-arr[1]+dp2[N-i+1]-arr2[1];
			result = Math.max(result, tmp);
			//왼
			tmp =0;
			tmp = dp2[N]-dp2[1]-arr2[i]+dp2[N]-dp2[i];
			result = Math.max(result, tmp);
		}
		
		System.out.println(result);
	}
}
