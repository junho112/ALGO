import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014_스타트링크 {
	static int F,S,G,U,D;
	static int goStair[];
	static boolean visit[];
	static int result[];
	public static void main(String[] argrs) {
		Scanner sc = new Scanner(System.in);
		//f : 층 g : 가야될 곳 s :현재위치 u : up d : down
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		//안되면 use the stairs
		goStair = new int[2];
		result = new int[F+1]; //결과값 저장! 
		goStair[0] = U;
		goStair[1] = -D;
		if(S==G) {
			System.out.println(0); //갈 필요 없음 
		}
		else {
			bfs(S);
		}
		
	}
	public static void bfs(int node) {
		visit = new boolean[F+1];
		Queue<Integer> mq = new ArrayDeque<>();
		visit[node] = true;
		mq.add(node);
		while(!mq.isEmpty()) {
			int current = mq.remove();
//			System.out.print(current+" ");
			if(current==G) {
				System.out.println(result[current]);
				return;
			}
			for(int next = 0;next<2;next++) {
				int a = current+goStair[next]; //a = 다음 갈 층수 
				if(a>0&&a<=F&&!visit[a]) { // 배열 범위 넘지 않기 위해서 넘을 것 같은 수 앞에 배치 
					result[a] = result[current]+1;
					visit[a] = true;
					mq.add(a);
				}
			}
		}
		System.out.println("use the stairs");
	}
}
