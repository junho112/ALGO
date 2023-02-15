import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_BFS와DFS {
	static 	List<ArrayList<Integer>> graph = new ArrayList<>(); 

	static boolean visit[];
	static boolean visit2[];
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int node = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		visit2 = new boolean[N+1];
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		for(int i=0;i<=N;i++) {
			Collections.sort(graph.get(i));
		}
		dfs(node);
		System.out.println();
		bfs(node);
	}

	private static void bfs(int node) {
		// TODO Auto-generated method stub
		Queue<Integer> mq = new ArrayDeque<>();
		mq.add(node);
		visit2[node] = true;
		
		while(!mq.isEmpty()) {
			int cur = mq.poll();
			System.out.print(cur+" ");
			for(int i=0;i<graph.get(cur).size();i++) {
				int tmp = graph.get(cur).get(i);
				if(!visit2[tmp]) {
					mq.add(tmp);
					visit2[tmp] = true;
				}
				
			}
		}
	}

	private static void dfs(int node) {
		// TODO Auto-generated method stub
		visit[node] = true;
		System.out.print(node+" ");
		for(int i=0;i<graph.get(node).size();i++) {
			int cur = graph.get(node).get(i);
			if(!visit[cur]) {
				dfs(cur);
			}
		}
	}
}
