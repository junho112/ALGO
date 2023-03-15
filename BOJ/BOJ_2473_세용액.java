import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액{
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		long result[] = new long[3];
		for(int i=0;i<N-2;i++) {
			int start = i+1;
			
			int end = N-1;
			
			while(start<end) {
				
				long tmp22 = arr[i]+arr[start]+arr[end];
				long tmp = Math.abs(arr[i]+arr[start]+arr[end]);
				if(tmp<min) {
					min = tmp;
					result[0] = arr[i];
					result[1] = arr[start];
					result[2] = arr[end];
				}
				if(tmp22>0) {
					end--;
					
				}else {
					start++;
				}
				
				
			}
		}
		Arrays.sort(result);
		System.out.println(result[0]+" "+result[1]+" "+result[2]);
	}
}
