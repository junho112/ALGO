import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,table[][],match[],res,matches[][],size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		table = new int[6][3];
		match = new int[2];
		matches = new int[15][2];
		
		back(0,0);
		for(int t = 0;t<4;t++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0);
			sb.append(res).append(" ");
		}
		System.out.println(sb);
	}
	private static void dfs(int def) {
		// TODO Auto-generated method stub
		if(def == 15) {
			boolean flag = true;
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					if(table[i][j] != 0) {
						flag = false;
					}
				}
			}
			if(flag) {
				res = 1;
			}
			return;
		}
		for(int i = 0; i < 3; i++) {
			//한쪽이 이기면 한쪽이 짐 
			// 무승부면 둘다 없앰 
			table[matches[def][0]][i]--;
			table[matches[def][1]][2-i]--;
			if(table[matches[def][0]][i] >= 0 &&table[matches[def][1]][2-i] >= 0) {
				dfs(def+1);
			}
			table[matches[def][0]][i]++;
			table[matches[def][1]][2-i]++;
		}
	}
	private static void back(int cnt, int start) {
		// TODO Auto-generated method stub
		// 대결 조합 만들기
		if(cnt==2) {
			matches[size++] = new int[] {match[0],match[1]};
			return;
		}
		for(int i=start;i<6;i++) {
			match[cnt] = i;
			back(cnt+1,i+1);
		}
	}
}
