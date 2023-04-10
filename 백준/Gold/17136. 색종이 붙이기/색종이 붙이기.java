

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int arr[][] = new int[10][10];

	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int one = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < 10; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if (arr[i][k] == 1) {
					one++;
				}
			}
		}
		int paper[] = new int[6];
		for (int i = 1; i <= 5; i++) {
			paper[i] = 5;
		}
		dfs(0, 0, 0, paper);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void dfs(int y, int x, int cnt, int[] paper) {
		// TODO Auto-generated method stub
		if(y>=9&&x>9) {
			min = Math.min(min, cnt);
			return;
		}
		if(x>9) {
			dfs(y+1,0,cnt,paper);
			return;
		}
		if(arr[y][x]==1) {
			for(int p=1;p<=5;p++) {
				if(y+p>10||x+p>10) continue;
				if(paper[p]<=0) continue;
				boolean flag = true;
				for(int i=y;i<y+p;i++) {
					for(int k=x;k<x+p;k++) {
						if(arr[i][k]==0) {
							flag = false;
						}
					}
				}
				if(flag) {
					for(int i=y;i<y+p;i++) {
						for(int k=x;k<x+p;k++) {
							arr[i][k] = 0;
						}
					}
					paper[p]--;
					dfs(y,x+1,cnt+1,paper);
					paper[p]++;
					for(int i=y;i<y+p;i++) {
						for(int k=x;k<x+p;k++) {
							arr[i][k] = 1;
						}
					}
				}
			}
		}else {
			dfs(y,x+1,cnt,paper);
		}
	}

	static void print() {
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				System.out.print(arr[i][k] + " ");
			}
			System.out.println();
		}
	}
}