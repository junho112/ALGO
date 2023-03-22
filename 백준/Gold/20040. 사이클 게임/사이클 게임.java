import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//초기화 
		parents = new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i] = i;
		}
		int result = 0;
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(find(a)==find(b)) {
				result = i;
				break;
			}
			union(a,b);
		}
		System.out.println(result);
	}
	private static void union(int a, int b) {
		// TODO Auto-generated method stub
		a = find(a);
		b = find(b);
		if(a!=b) {
			parents[b] = a;
		}
	}
	private static int find(int a) {
		// TODO Auto-generated method stub
		if(parents[a] == a) {
			return a;
		}else {
			return parents[a] = find(parents[a]);
		}
	}

}
