import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int alen = a.length();
		int blen = b.length();
		int max = 0;
		int dp[][] = new int[alen+1][blen+1];
		for(int i=1;i<=alen;i++) {
			for(int k=1;k<=blen;k++) {
				if(a.charAt(i-1)==b.charAt(k-1)) {
					dp[i][k] = dp[i-1][k-1]+1;
				}else {
					dp[i][k] = Math.max(dp[i-1][k], dp[i][k-1]);
				}
				max = Math.max(dp[i][k], max);
			}
		}
		Stack<Character> st = new Stack<>();
		int i = alen;
		int k = blen;
		while(i>0&&k>0) {
			if(i==0||k==0) break;
			if(dp[i][k]==dp[i-1][k]) {
				i--;
			}else if(dp[i][k]==dp[i][k-1]) {
				k--;
			}else {
				st.push(a.charAt(i-1));
				i--;
				k--;
			}
		}
		System.out.println(max);
		for(int x=0;x<max;x++) {
			System.out.print(st.pop());
		}

	}
}
