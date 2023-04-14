import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static int parent[];
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Node edge[] = new Node[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge[i] = new Node(a,b,c);
		}
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		Arrays.sort(edge);
		int result = 0;
		int cnt = 0;
		for(int i=0;i<M;i++) {
			Node node = edge[i];
			if(find(node.n1)!=find(node.n2)) {
				result = result + node.w;
				union(node.n1,node.n2);
				cnt = node.w;
			}
		}
		System.out.println(result-cnt);
	}	
	private static void union(int a, int b) {
		// TODO Auto-generated method stub
		int a1 = find(a);
		int b1 = find(b);
		if(a1!=b1) {
			parent[b1]= a1;
		}
	}
	
	private static int find(int a) {
		// TODO Auto-generated method stub
		if(parent[a] == a) {
			return a;
		}else {
			return parent[a] = find(parent[a]);
		}
	}











	static class Node implements Comparable<Node>{
		int n1;
		int n2;
		int w;
		public Node(int n1, int n2, int w) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		@Override
		public int compareTo(Main.Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
	}
}