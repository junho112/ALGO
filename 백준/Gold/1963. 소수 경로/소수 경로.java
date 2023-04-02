import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean prime[];
	static boolean visit[];
	static int start[] = new int[4];
	static int end[] = new int[4];
	static int count[];
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		prime = new boolean[10000];
		isPrime();
		//false 가 prime
		for(int test=1;test<=N;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startt = Integer.parseInt(st.nextToken());
			int endd = Integer.parseInt(st.nextToken());
			visit = new boolean[10000];
			count = new int[10000];
			Queue<Integer> mq = new ArrayDeque<>();
			mq.add(startt);
			visit[startt] = true;
			while(!mq.isEmpty()) {
				int tmp = mq.poll();
				for(int i=0;i<4;i++) { //자리수
					for(int k=0;k<=9;k++) {
						if(i==0&&k==0) {
							continue;
						}
						int tmptmp = indexChange(tmp,i,k);
						if(!prime[tmptmp]&&!visit[tmptmp]) {
							mq.add(tmptmp);
							visit[tmptmp] = true;
							count[tmptmp] = count[tmp] +1;
						}
					}
				}
			}
			System.out.println(count[endd]);
		
		
		
		}
	}
	
	private static int indexChange(int tmp, int i, int k) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(String.valueOf(tmp));
		sb.setCharAt(i, (char)(k+'0'));
		return Integer.parseInt(sb.toString());
	}

	private static void isPrime() {
		// TODO Auto-generated method stub
		prime[0] = true;
		prime[1] = true;
		for(int i=2;i*i<10000;i++) {
			if(!prime[i]) {
				for(int k=i*i;k<10000;k+=i) {
					prime[k] = true;
				}
			}
		}
		for(int i=0;i<=1000;i++) {
			prime[i] = true;
		}
		
	}
}
