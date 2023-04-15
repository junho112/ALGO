import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	static int N ;
	static int parents[];
	public static void main(String[] agrs) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		double tmp[][] = new double[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			tmp[i][0] = a;
			tmp[i][1] = b;
		}
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(i==k) continue;
				double dis = Math.sqrt((tmp[i][0] - tmp[k][0])*(tmp[i][0] - tmp[k][0])+(tmp[i][1] - tmp[k][1])*(tmp[i][1] - tmp[k][1]));
				list.add(new Node(i,k,dis));
			}
		}
		Collections.sort(list);
		parents = new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i] = i;
		}
		double result = 0;
		int cnt = 0;
		for(int i=0;i<list.size();i++) {
			if(union(list.get(i).n1,list.get(i).n2)) {
				result = result+list.get(i).w;
				cnt ++;
			}
			if(cnt==N-1) {
				break;
			}
		}
		System.out.println(result);
	}
	
	
	
	private static boolean union(int a, int b) {
		// TODO Auto-generated method stub
		int a1 = find(a);
		int b1 = find(b);
		if(a1==b1) {
			return false;
		}else {
			parents[b1] = a1;
			return true;
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



	static class Node implements Comparable<Node>{
		int n1;
		int n2;
		double w;
		public Node(int n1, int n2, double w) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		@Override
		public int compareTo(Main.Node o) {
			// TODO Auto-generated method stub
			return (int) (this.w-o.w);
		}
		
	}
}