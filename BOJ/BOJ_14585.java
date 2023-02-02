package algo;

import java.util.Scanner;

public class BOJ_14585 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int candy = sc.nextInt();
		int arr[][] = new int[a][2];
		boolean check[][] = new boolean[301][301];
		int xmax = 0;
		int ymax = 0;
		for(int i=0;i<a;i++) {
			arr[i][0] = sc.nextInt();
			xmax = Math.max(xmax, arr[i][0]);
			arr[i][1] = sc.nextInt();
			ymax = Math.max(ymax, arr[i][1]);
			check[arr[i][0]][arr[i][1]] = true;
		}
		int result[][] = new int[xmax+1][ymax+1];
		for(int i=0;i<=ymax;i++) {
			for(int k=0;k<=xmax;k++) {
				if(k==0&&i==0) {
					result[k][i] = 0;
				}
				else if(k==0) {
					result[k][i] = result[k][i-1];
				}
				else if(i==0) {
					result[k][i] = result[k-1][i];
 				}
				else {
					result[k][i] = Math.max(result[k-1][i],result[k][i-1]);

				}
				if(check[k][i]) {
					int remain = candy - k-i;
					if(remain>0) {
						result[k][i] = result[k][i] + remain;
					}
				}
//				System.out.println(k+" "+i+" "+result[k][i]);
			}
		}
		System.out.println(result[xmax][ymax]);
	}
}
