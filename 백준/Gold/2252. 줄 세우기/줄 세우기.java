import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		int count[] = new int[N+1];
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			count[b]++;
		}
		
		Queue<Integer> mq = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			if(count[i]==0) {
				mq.add(i);
			}
		}
		while(!mq.isEmpty()) {
			int tmp = mq.poll();
			System.out.print(tmp+" ");
			for(int i=0;i<list.get(tmp).size();i++) {
				count[list.get(tmp).get(i)]--;
				if(count[list.get(tmp).get(i)]==0) {
					mq.add(list.get(tmp).get(i));
				}
			}
		}
		br.close();
	}
}