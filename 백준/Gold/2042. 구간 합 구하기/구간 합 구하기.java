import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static long tree[];
	static long arr[];
	static int N,M,K;
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 수의 변경
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		for(int i=1;i<=N;i++) {
			update(i,arr[i]);
		}
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				long c= Long.parseLong(st.nextToken());
				long tmp = arr[b];
				arr[b] = c;
				update(b,c-tmp);
			}else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long sum = sum(b,c);
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	private static Long sum(int b, int c) {
		// TODO Auto-generated method stub
		long tmp = sum(c) - sum(b-1);
		return tmp;
	}
	private static long sum(int i) {
		// TODO Auto-generated method stub
		long result = 0;
		while(i>0) {
			result +=tree[i];
			i -= (i&-i);
		}
		
		return result;
	}
	private static void update(int i, long num) {
		// TODO Auto-generated method stub
		while(i<=N) {
			tree[i] = tree[i] + num;
			i += (i&-i);
		}
	}
}
