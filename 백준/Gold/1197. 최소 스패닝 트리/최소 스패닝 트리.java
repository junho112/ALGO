

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from , to , weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			// 오름차순 정렬 
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	
	static void makeSet() {
		parents = new int[V+1];
		for(int i=1;i<=V;i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}else {
			//패스 압축+ 자신의 부모를 통해서 알아보기 
			return parents[a]=findSet(parents[a]);
		}
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] agrs) {

		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		edgeList = new Edge[E];
		
		for(int i=0;i<E;i++) {
			edgeList[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(edgeList);
		makeSet();
		int result = 0, cnt = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++cnt ==V-1) break;
			}
		}
		System.out.println(result);
		
	}
}
