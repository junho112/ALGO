import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void BOJ_14890_경사로(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		//가로
		int result = 0;
		for(int i=0;i<N;i++) {
			boolean flag = true;
			int up = 0;
			int down = 0;
			int pp = 1;
			int pd = 0;
			int len = arr[i][0];
			for(int k=1;k<N;k++) {				
				if(len==arr[i][k]) {
					pp++;
					if(pd>0) {
						pd++;
					}
				}
				else if(len+1==arr[i][k]) { //올라가기
					if(pd>0&&pd<C) {
						flag = false;
					}
					else if(pd>0&&pd>=C) {
						if(pd<2*C) {
							flag = false;
						}
						else {
							pd = 0;
							len  = arr[i][k];
						}
					}
					else if(pp>=C) {
						pp=1;
						len = arr[i][k];
					}else {
						flag = false;
					}
				}else if(len-1==arr[i][k]) { //내려가기
					if(pd>0&&pd<C) {
						flag = false;
					}
					else if(pd>0&&pd>=C) {
						len = arr[i][k];
						pd = 1;
						pp = 0;
					}
					else {
						pd++;
						len = arr[i][k];
					}
				}else {
					flag = false;
				}
				
			}
			if(pd>0&&pd<C) {
				flag = false;
			}
			if(flag) {
//				System.out.println("가로"+i);
				result++;
			}
		}
		
		////////////
		for(int i=0;i<N;i++) {
			boolean flag = true;
			int up = 0;
			int down = 0;
			int pp = 1;
			int pd = 0;
			int len = arr[0][i];
			for(int k=1;k<N;k++) {				
				if(len==arr[k][i]) {
					pp++;
					if(pd>0) {
						pd++;
					}
				}
				else if(len+1==arr[k][i]) { //올라가기
					if(pd>0&&pd<C) {
						flag = false;
					}
					else if(pd>0&&pd>=C) {
						if(pd<2*C) {
							flag = false;
						}
						else {
							pd = 0;
							len  = arr[k][i];
						}
					}
					else if(pp>=C) {
						pp=1;
						len = arr[k][i];
					}else {
						flag = false;
					}
				}else if(len-1==arr[k][i]) { //내려가기
					if(pd>0&&pd<C) {
						flag = false;
					}
					else if(pd>0&&pd>=C) {
						len = arr[k][i];
						pd = 1;
						pp = 0;
					}
					else {
						pd++;
						len = arr[k][i];
					}
				}else {
					flag = false;
				}
				
			}
			if(pd>0&&pd<C) {
				flag = false;
			}
			if(flag) {
//				System.out.println("세로"+i);
				result++;
			}
		}
		System.out.println(result);
	}
}

/*

*/


