import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean visit[];
	static int N,M;
	static List<Location> home = new ArrayList<>();
	static List<Location> chic = new ArrayList<>();
	static Location chicArr[];
	static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
		//1 -> 집  2 -> 치킨집  M -> 치킨집 최대 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	chicArr = new Location[M];
    	int arr[][] = new int[N+1][N+1];
    	for(int i=1;i<=N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int k=1;k<=N;k++) {
    			arr[i][k] = Integer.parseInt(st.nextToken());
    			if(arr[i][k]==1) {
    				home.add(new Location(i,k));
    			}
    			else if(arr[i][k]==2) {
    				chic.add(new Location(i,k));
    			}
    		}
    	}
    	visit = new boolean[chic.size()];
    	back(0,0);
    	System.out.println(minResult);
	}
	private static void back(int def,int start) {
		// TODO Auto-generated method stub
		if (def == M) {
			//계산
			int min2 = 0;
			for(int k=0;k<home.size();k++) {
				int min = Integer.MAX_VALUE;
				for(int j=0;j<M;j++) {
					int tmp =Math.abs(home.get(k).x - chicArr[j].x) + Math.abs(home.get(k).y - chicArr[j].y);
					min = Math.min(tmp,min);
				}
				min2 = min2+min;
			}
			minResult = Math.min(min2, minResult);
			return;
		}
		for(int i=start;i<chic.size();i++) {
			visit[i] = true;
			chicArr[def] = chic.get(i);
			back(def+1,i+1);
			visit[i] = false;
		}
	}

}




class Location{
	int x;
	int y;
	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
