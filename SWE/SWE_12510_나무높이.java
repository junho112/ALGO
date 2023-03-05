import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWE_12510_나무높이{
	//홀수날 1
	//짝수날 2   -> 최소 날 
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1;test<=T;test++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
//			System.out.println(Arrays.toString(arr));
			int big = arr[N-1];
			int one = 0;
			int two = 0;
			int day = 0;
			for(int i=0;i<N-1;i++) {
				if(arr[i]==big) {
					continue;
				}
				one = one + (big-arr[i])%2; //1 2 -> 4 
				two = two + (big-arr[i])/2; //6 5  ->4
				// 2를 1에 나눠줘야함
				//배분한 최소 날
			}
			int tmp = Math.max(two-one, 0)/3; //1 6
			one = one +tmp*2;  // 5
			two = two-tmp; // 4
			int onetwo = Math.min(one, two);
//			day = onetwo*2+Math.max((one-onetwo)*2-1, 0)+(two-onetwo)/2*3+(two-onetwo)%2*2;
			day = onetwo*2+Math.max((one-onetwo)*2-1, 0)+(two-onetwo)/2*3+(two-onetwo)%2*2;

			System.out.println("#"+test+" "+day);
			
			//2 3 5 10 -> 14                                 1 2 1 
			// 8 + 7 + 5  ---> 2+2+1 ---> 10일    ----> 2,1,2   ---> 1+1+1+1 --> 4일 
			
		}
	}
}
