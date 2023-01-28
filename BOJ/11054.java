package algo;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int arr[] = new int[a];
		int dp[] = new int[a];
		for(int i=0;i<a;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<a;i++) {// k    i   
			dp[i] = 1;
			for(int k=0;k<i;k++) {
				if(arr[k]<arr[i]&&dp[i]<dp[k]+1) {
					dp[i] = dp[k]+1;
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		int result = 0;
		for(int i=0;i<a;i++) {
			result = Math.max(dp[i], result);
		}
		System.out.println(result);
	}
}	
