import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static int dp[][];
	static final int INF = Integer.MAX_VALUE/100;
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[1<<N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<1<<N;i++) {
			Arrays.fill(dp[i], -1);
		}
		int result = tsp(1,0);
		System.out.println(result);
	}
	private static int tsp(int visit, int city) {
		// TODO Auto-generated method stub
		if(visit==(1<<N)-1) {
			if(arr[city][0]==0) { //연결 여부 
				return INF;
			}
			return arr[city][0]; //연결되있으면 리턴
		}
		if(dp[visit][city]!=-1) { // 이미 방문된 곳이라면 바로 리턴
			return dp[visit][city];
		}
		dp[visit][city] = INF; //계싼햇다는 뜻
		for(int i=0;i<N;i++) {
			if((visit &(1<<i))!=0) {
				continue;
			}
			if(arr[city][i]==0) {
				continue;
			}
			dp[visit][city] = Math.min(tsp((visit|1<<i),i)+arr[city][i], dp[visit][city]);
		}
		return dp[visit][city];
	}
}
