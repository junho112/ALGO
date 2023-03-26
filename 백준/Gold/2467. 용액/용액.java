import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long min = Long.MAX_VALUE;
		int ll = 0;
		int rr = 0;
		for(int i=0;i<N-1;i++) {
			int left = i+1;
			int right = N-1;
			while(left<=right) {
				int mid = (left+right)/2;
				long sum = Math.abs(arr[i]+arr[mid]);
				if(min>sum) {
//					System.out.println(arr[i]+" "+arr[mid]);
					min = sum;
					ll = i;
					rr = mid;
				}
				if(arr[mid]+arr[i]>=0) {
					right = mid-1;
				}else {
					left = mid+1;
				}
			}
		}
		System.out.println(arr[ll]+" "+arr[rr]);
	}

}
