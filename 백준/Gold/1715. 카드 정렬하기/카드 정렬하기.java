import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		PriorityQueue<Integer> mq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			mq.add(Integer.parseInt(br.readLine()));
		}
		int result = 0;
		while(!mq.isEmpty()) {
			if(mq.size()==1) {
				mq.poll();
				continue;
			}
			int tmp1 = mq.poll();
			int tmp2 = mq.poll();
			result+= tmp1+tmp2;
			mq.add(tmp1+tmp2);
		}
		System.out.println(result);
	}
}
