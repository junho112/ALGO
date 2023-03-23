import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		Deque<Node> dq = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty()&&dq.getLast().a>tmp) {
				dq.removeLast();
			}
			dq.addLast(new Node(i,tmp));
			
			if(dq.getFirst().idx<=i-L) {
				dq.removeFirst();
			}
			sb.append(dq.getFirst().a).append(" ");
		}
		System.out.println(sb);
	}
	
	
	
	static class Node{
		int idx;
		int a;
		public Node(int idx, int a) {
			super();
			this.idx = idx;
			this.a = a;
		}
		
	}
}