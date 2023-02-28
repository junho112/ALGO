import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링{
	static int N;
	static int score[];
	static boolean visit[];
	static int result = Integer.MAX_VALUE; //결과값 저장 
	static boolean flag = true;
	static List<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		score = new int[N+1];
		visit = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int tmparr[] = new int[n];
			for(int k=0;k<n;k++) {
				int aa = Integer.parseInt(st.nextToken());
				list.get(i).add(aa);
//				list.get(aa).add(i);
			}
		}
		for(int i=0;i<=N;i++) {
			Collections.sort(list.get(i));
		}

		dfs(1); //1번 구역부터 탐색 
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}
	private static void dfs(int def) {
		// TODO Auto-generated method stub
		if(def == N) {
			gary();
			return;
		}
		visit[def] = false;
		dfs(def+1);
		visit[def] = true;
		dfs(def+1);
	}
	private static void gary() {
		// TODO Auto-generated method stub
		List <Integer> aTeam = new ArrayList<>();
		List <Integer> bTeam = new ArrayList<>();
//		System.out.println(1111);
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				aTeam.add(i);
			}else {
				bTeam.add(i);
			}
		}
		flag = true;
		if(aTeam.size()>1) {
			for(int i=0;i<aTeam.size();i++) {
				int a = aTeam.get(i);
				 if(!bfsF(a)) {
					 return;
				 }
			}
		}
		if(bTeam.size()>1) {
			for(int i=0;i<bTeam.size();i++) {
				int a = bTeam.get(i);
				 if(!bfsT(a)) {
					 return;
				 }
			}
		}
		int tmpA=0;
		int tmpB=0;
		for(int i=1;i<=N;i++) {
			if(visit[i]) {
				tmpA+=score[i];
			}
			else {
				tmpB+=score[i];
			}
		}
//		System.out.println(Arrays.toString(visit));
		int re = Math.abs(tmpA-tmpB);
		result = Math.min(result, re);
	}
	private static boolean bfsT(int a) {
		Queue<Integer> mq = new ArrayDeque<>();
		boolean[] visitC = Arrays.copyOf(visit, N+1);
		mq.add(a);
		visitC[a] = false;
		while(!mq.isEmpty()) {
			int curr = mq.poll();
			for(int i=0;i<list.get(curr).size();i++) {
				if(visitC[list.get(curr).get(i)]) {
					visitC[list.get(curr).get(i)] = false;
					mq.add(list.get(curr).get(i));
				}
			}
		}
		for(int i=1;i<=N;i++) {
			if(visitC[i]==true) {
				return false;
			}
		}
		return true;
	}
	private static boolean bfsF(int a) {
		// TODO Auto-generated method stub
		Queue<Integer> mq = new ArrayDeque<>();
		boolean[] visitC = Arrays.copyOf(visit, N+1);
		mq.add(a);
		visitC[a] = true;
		while(!mq.isEmpty()) {
			int curr = mq.poll();
			for(int i=0;i<list.get(curr).size();i++) {
				if(!visitC[list.get(curr).get(i)]) {
					visitC[list.get(curr).get(i)] = true;
					mq.add(list.get(curr).get(i));
				}
			}
		}
		for(int i=1;i<=N;i++) {
			if(visitC[i]==false) {
				return false;
			}
		}
		return true;
	}
}
