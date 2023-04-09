
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main{
	static int damage[][] = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,3,9},{1,9,3}};
	static int min = Integer.MAX_VALUE;
	static int INF = Integer.MAX_VALUE/100;
	static int dp[][][] = new int[61][61][61];
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Integer arr[] = new Integer[3];
		for(int i=0;i<T;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<61;i++) {
			for(int k=0;k<61;k++) {
				for(int j=0;j<61;j++) {
					dp[i][k][j] = INF;
				}
			}
		}
		for(int i=T;i<3;i++) {
			arr[i] = 0;
		}
//		System.out.println(Arrays.toString(arr));
		int cnt = dfs(arr.clone(),0);
		System.out.println(cnt);
	}
	/**
	 * 9 3 1
	 * 9 1 3
	 * 3 9 1
	 * 3 1 9
	 * 1 3 9
	 * 1 9 3 
	 * @param arr
	 * @param def
	 * @return
	 */
	private static int dfs(Integer[] arr,int def) {
		Arrays.sort(arr,Collections.reverseOrder());
		int s1 = arr[0];
		int s2 = arr[1];
		int s3 = arr[2];
		if(s1<=0&&s2<=0&&s3<=0) {
			return def;
		}
		if(dp[s1][s2][s3]!=INF) { //들린데임 
			return dp[s1][s2][s3];
		}
		for(int i=0;i<6;i++) {
			int tmps1 = s1-damage[i][0];
			if(tmps1<0) {
				tmps1 = 0;
			}
			int tmps2 = s2-damage[i][1];
			if(tmps2<0) {
				tmps2 = 0;
			}
			int tmps3 = s3-damage[i][2];
			if(tmps3<0) {
				tmps3 = 0;
			}
			Integer tmparr[] = new Integer[3];
			tmparr[0] = tmps1;
			tmparr[1] = tmps2;
			tmparr[2] = tmps3;
//			Arrays.sort(tmparr);
//			System.out.println(tmps1+" "+tmps2+" "+tmps3+" "+def);
			dp[s1][s2][s3] = Math.min(dp[s1][s2][s3],dfs(tmparr,def+1));
		}
		return dp[s1][s2][s3];
	}

}