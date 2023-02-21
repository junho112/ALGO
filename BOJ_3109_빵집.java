import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	static int arr[][];
	static int dy[] = {-1,0,1};//대각위 중간 대각아래
	static int dx[] = {1,1,1};
	static int result = 0;
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for(int i=0;i<r;i++) { //건물 있는 곳은 1;
			String str = br.readLine();
			for(int k=0;k<c;k++) {
				if(str.charAt(k)=='.') {
					arr[i][k] = 0;
				}else {
					arr[i][k] = 1;
				}
			}
		}
//		for(int i=0;i<r;i++) {
//			for(int k=0;k<c;k++) {
//				System.out.print(arr[i][k]+" ");
//			}
//			System.out.println();
//		}
		for(int i=0;i<r;i++) {
			dfs(i,0);
			flag = true;
		}
		System.out.println(result);
	}
	private static void dfs(int y,int x) { //def == c;
		// TODO Auto-generated method stub
		if(x == c-1) {
			result++;
			//맞는지 획인 
			flag=false;
			return;
		}
		for(int i=0;i<3;i++) {
			int cy = y+dy[i];
			int cx = x+dx[i];
//			System.out.println("첫번"+ cy+" "+cx);
			if(cy>=0&&cy<r&&cx>=0&&cx<c&&arr[cy][cx]==0) {
//				System.out.println("통과"+ cy+" "+cx);
				arr[cy][cx] = 1;
				dfs(cy,cx);
				if(!flag) {
					return;

				}
			}
		}
	}
}
		
		  
