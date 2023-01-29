package algo;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static int arr[][];
	static int rotate[][];
	static boolean visit[];
	static int save[];
	static int k;
	static int N;
	static int M;
	static int realresult = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		k = sc.nextInt();
		visit = new boolean[k];
		save = new int[k];
		rotate = new int[k][3];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<k;i++) {
			rotate[i][0] = sc.nextInt();
			rotate[i][1] = sc.nextInt();
			rotate[i][2] = sc.nextInt();
		}
		Back(0);
		System.out.println(realresult);
	}
	
	public static void Back(int def) {
		if(def==k) {
			//checkmin
			int[][] copy = new int[arr.length][];
	        for (int i = 0; i < arr.length; i++) {
	            copy[i] = arr[i].clone();
	        }

			for(int b=0;b<k;b++) {
				int r = rotate[save[b]][0];
				int c = rotate[save[b]][1];
				int s = rotate[save[b]][2];
				Rot(r-s-1,c-s-1,r+s-1,c+s-1,copy);
//				for(int i=0;i<N;i++) {
//					for(int j=0;j<M;j++) {
//						System.out.printf("%3d",copy[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
			realresult = Math.min(realresult, minmin(copy));

		}
		for(int q=0;q<k;q++) {
			if(!visit[q]) {
				visit[q] = true;
				save[def] = q; 
				Back(def+1);
				visit[q] = false;
			}
		}
		
	}
		
	
	public static int minmin(int[][] copy) {
		int result = Integer.MAX_VALUE;
		for(int h1=0;h1<N;h1++) {
			int sum =0;
			for(int h2=0;h2<M;h2++) {
				sum = sum+copy[h1][h2];
			}
			result = Math.min(result, sum);
		}
		return result;
	}

	
	public static void Rot(int x1,int y1,int x2,int y2,int[][] copy) {
		if(x1==x2) {
			return;
		}
		int num = x2-x1;
		int tmp = 0;
		int tmp2= 0 ;
		for(int i =0;i<num;i++) {
			tmp2 = copy[x1][y1+i];
			copy[x1][y1+i] = tmp;
			tmp = tmp2;
		}
		for(int i =0;i<num;i++) {
			tmp2 = copy[x1+i][y2];
			copy[x1+i][y2] = tmp;
			tmp = tmp2;
		}
		for(int i =0;i<num;i++) {
			tmp2 = copy[x2][y2-i];
			copy[x2][y2-i] = tmp;
			tmp = tmp2;
		}
		for(int i =0;i<num;i++) {
			tmp2 = copy[x2-i][y1];
			copy[x2-i][y1] = tmp;
			tmp = tmp2;
		}
		copy[x1][y1] = tmp;
		Rot(x1+1,y1+1,x2-1,y2-1,copy);
	}
}	
