import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final double INF = Double.MAX_VALUE/100;
	static int N;
	static double arr[][];
	static double dp[][];
	public static void main(String[] agrs) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new double[N][N];
		dp = new double[1<<N][N];
		double tmp[][] = new double[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			tmp[i][0] = a;
			tmp[i][1] = b;
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				arr[i][k] = Math.sqrt(((tmp[i][0]-tmp[k][0])*(tmp[i][0]-tmp[k][0]))+(((tmp[i][1]-tmp[k][1]))*((tmp[i][1]-tmp[k][1]))));
			}
		}
		for(int i=0;i<(1<<N);i++) {
			Arrays.fill(dp[i], -1);
		}
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<N;k++) {
//				System.out.print(arr[i][k]+ " ");
//			}
//			System.out.println();
//		}
		double cnt = TSP(1,0);
		System.out.println(cnt);
//		for(int i=0;i<N;i++) {
//			for(int k=0;k<1<<N;k++) {
//				System.out.print(dp[k][i]+ " ");
//			}
//			System.out.println();
//		}
		
	}
	private static double TSP(int visit, int city) {
		// TODO Auto-generated method stub
		if(visit==(1<<N)-1) {
			if(arr[city][0]==0) {
				return INF;
			}
			return arr[city][0];
		}
		if(dp[visit][city]!=-1) {
			return dp[visit][city];
		}
		dp[visit][city] = INF;
		for(int i=0;i<N;i++) {
			if((visit&(1<<i))!=0) {
				continue;
			}
			if(arr[city][i]==0) {
				continue;
			}
			dp[visit][city] = Math.min(TSP((visit|1<<i),i)+arr[i][city], dp[visit][city]);
		}
		return dp[visit][city];
	}

	
}
