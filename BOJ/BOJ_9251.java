package algo;


import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9251 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int dp[][] = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<str1.length();i++) {
			dp[i][0] = 0;
		}
		for(int i=0;i<str2.length();i++) {
			dp[0][i] = 0;
		}
		for(int i=1;i<=str1.length();i++) {
			for(int k=1;k<=str2.length();k++) {
				if(str1.charAt(i-1)==str2.charAt(k-1)) {
					dp[i][k]= dp[i-1][k-1]+1;
				}
				else {
					dp[i][k] = Math.max(dp[i-1][k],dp[i][k-1]);
				}
			}
		}
		int max= 0;
		for(int i=0;i<=str1.length();i++) {
			for(int k=0;k<=str2.length();k++) {
//				System.out.print(dp[i][k]+" ");
				max = Math.max(dp[i][k], max);
			}
//			System.out.println();
		}
		System.out.println(max);
	}
}
