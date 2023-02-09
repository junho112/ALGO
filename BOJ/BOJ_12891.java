import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[4];
		int result = 0;
		for(int i=0;i<4;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<P;i++) {
			if(str.charAt(i)=='A') {
				arr[0]--;
			}
			else if(str.charAt(i)=='C') {
				arr[1]--;
			}
			else if(str.charAt(i)=='G') {
				arr[2]--;
			}
			else if(str.charAt(i)=='T') {
				arr[3]--;
			}
		}
		if(arr[0]<1&&arr[1]<1&&arr[2]<1&&arr[3]<1) {
			result++;
		}
		
		
		for(int i=1;i<=S-P;i++) {//  1 2
			char str1 = str.charAt(i-1);
			if(str1=='A') {
				arr[0]++;
			}
			else if(str1=='C') {
				arr[1]++;
			}
			else if(str1=='G') {
				arr[2]++;
			}
			else if(str1=='T') {
				arr[3]++;
			}
			char str2 = str.charAt(i+P-1);
			if(str2=='A') {
				arr[0]--;
			}
			else if(str2=='C') {
				arr[1]--;
			}
			else if(str2=='G') {
				arr[2]--;
			}
			else if(str2=='T') {
				arr[3]--;
			}

			if(arr[0]<1&&arr[1]<1&&arr[2]<1&&arr[3]<1) {
				result++;
			}
		}
		System.out.println(result);
	}
}
