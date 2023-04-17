import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		for(int test = 1; test <= T ;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int time[] = new int[N+1];
			int result[] = new int[N+1];

			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			int count[] = new int[N+1];
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			for(int i=0;i<=N;i++) {
				list.add(new ArrayList<>());
			}

			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				count[b]++;
			}
			int cnt = Integer.parseInt(br.readLine());
			Queue<Integer> mq = new ArrayDeque<>();
			for(int i=1;i<=N;i++) {
				if(count[i] == 0) {
					result[i] = time[i];
					mq.add(i);
				}
			}
			while(!mq.isEmpty()) {
				int tmp = mq.poll();
				for(int i=0;i<list.get(tmp).size();i++) {
					int node = list.get(tmp).get(i);
					result[node] = Math.max(result[node], result[tmp]+time[node]);
					count[list.get(tmp).get(i)]--;
					if(count[list.get(tmp).get(i)]==0) {
						mq.add(list.get(tmp).get(i));
					}
				}
			}
			System.out.println(result[cnt]);
		}
		
	}
}