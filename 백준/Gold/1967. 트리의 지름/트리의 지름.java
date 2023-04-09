import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean visit[];
	static int result = 0;
	static List<ArrayList<Node>> list = new ArrayList<>();
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList());
		}
		visit = new boolean[N+1];
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
		}
		for(int i=0;i<=N;i++) {
			visit = new boolean[N+1];
			visit[i] = true;
			dfs(i,0);
		}
		System.out.println(result);
	}
		
	private static void dfs(int node,int cnt) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.get(node).size();i++) {
			if(!visit[list.get(node).get(i).index]) {
				visit[list.get(node).get(i).index] = true;
				dfs(list.get(node).get(i).index,cnt+list.get(node).get(i).len);
			}
		}
		result = Math.max(result, cnt);
		
	}









	static class Node{
		int index;
		int len;
		public Node(int index, int len) {
			super();
			this.index = index;
			this.len = len;
		}
		
	}
}
