import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static final int INF = 10000000;
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(i!=k&&arr[i][k]==0) {
					arr[i][k] = INF;
				}
			}
		}
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			if(arr[a][b]>c) {
				arr[a][b] = c;
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if(i==k) continue;
				for(int j=0;j<N;j++) {
					if(i==j||k==j) continue;
					if(arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(arr[i][k]>=INF) {
					arr[i][k] = 0;
				}
				System.out.print(arr[i][k]+" ");
			}
			System.out.println();
		}
		
	}
}