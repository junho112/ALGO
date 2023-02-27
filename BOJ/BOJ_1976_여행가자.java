import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자{
	static int parent[];
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=1;k<=N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		//makeSet
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		for(int i=1;i<=N;i++) {
			for(int k=1;k<=N;k++) {
				if(arr[i][k]==1) {
					union(i,k);
				}
			}
		}
		int city[] = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<M-1;i++) {
			if(find(city[i])!=find(city[i+1])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static void union(int i, int k) {
		// TODO Auto-generated method stub
		 i = find(i);
		 k = find(k);
		 if(i!=k) {
			 if(i<k) {
				 parent[i] = k;
			 }else {
				 parent[k] = i;
			 }
		 }
	}

	private static int find(int i) {
		// TODO Auto-generated method stub
		if(parent[i] == i) {
			return i;
		}else {
			return parent[i] = find(parent[i]);
		}
	}
}
