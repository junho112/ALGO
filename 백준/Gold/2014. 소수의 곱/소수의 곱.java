import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int arr[] = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.add(arr[i]);
		}
		int tmp = 0;
		for (int i = 0; i < N ; i++) {
			tmp = pq.poll();
			for (int k = 0; k < K; k++) {
				long tmptmp = (long)arr[k] *(long) tmp;
				if(tmptmp>=((long)2<<30)) {
					break;
				}
				pq.add((int)tmptmp);
				if(tmp%arr[k]==0) {
					break;
				}
				
			}
		}
		System.out.println(tmp);

	}
}