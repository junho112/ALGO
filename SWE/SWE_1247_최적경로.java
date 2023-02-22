import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1247_최적경로 {
	static int N;
	static boolean visit[];
	static int result[];
	static Location[] guest;
	static Location start,last;
	static int realMin;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//N명고객
		//순열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 1;test<=t;test++) {
			realMin = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			visit = new  boolean[N];
			result = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			last = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			guest = new Location[N];
			for(int i=0;i<N;i++) {
				guest[i] = new Location(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			back(0);
			System.out.println("#"+test+" "+realMin);
		}
	}
	private static void back(int def) {
		// TODO Auto-generated method stub
		if(def ==N) {
			//계산
			checkMin();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[def] = i; 
				back(def+1);
				visit[i] = false;
			}
		}
	}
	private static void checkMin() {
		// TODO Auto-generated method stub
		int min = 0;
		min = Math.abs(start.y-guest[result[0]].y)+Math.abs(start.x-guest[result[0]].x);
		for(int i=1;i<N;i++) {
			min = min + Math.abs(guest[result[i-1]].y-guest[result[i]].y)+Math.abs(guest[result[i-1]].x-guest[result[i]].x);
		}
		min = min + Math.abs(last.y-guest[result[N-1]].y)+Math.abs(last.x-guest[result[N-1]].x);
		realMin = Math.min(min, realMin);
	}

}






class Location{
	int y;
	int x;
	public Location(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}
