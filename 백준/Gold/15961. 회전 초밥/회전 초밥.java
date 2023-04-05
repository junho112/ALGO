import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 접시 수 N 초밥 수 d 연속 k 쿠폰 번호 c
	 */
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int visit[] = new int[D + 1];
		// 초기 세팅
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			if(arr[i]!=C) {
				if(visit[arr[i]]==0) {
					cnt++;
					visit[arr[i]]++;
				}else {
					visit[arr[i]]++;
				}
			}
		}
//		System.out.println(cnt);
		int result = cnt;
		// 뒤포인터
		int end = K-1;
//		System.out.println(Arrays.toString(visit));

		for (int i = 1; i < N; i++) {
			end = (end+1)%N;
//			System.out.println(i-1+" "+end);
			//빼기 
			if(arr[i-1]!=C) {
				if(visit[arr[i-1]]>1) {
					visit[arr[i-1]]--;
				}else if(visit[arr[i-1]]==1) {
					visit[arr[i-1]]--;
					cnt--;
				}
			}
			
			//넣기
			if(arr[end]!=C) {
				if(visit[arr[end]]>=1) {
					visit[arr[end]]++;
				}else if(visit[arr[end]]==0) {
					visit[arr[end]]++;
					cnt++;
				}
			}
//			System.out.println(Arrays.toString(visit));
//			System.out.println(cnt);
			result = Math.max(result, cnt);
		}
		System.out.println((result+1));
	}
}