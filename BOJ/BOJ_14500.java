package algo;

import java.util.Scanner;

public class BOJ_14500 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tetris[][][]={
				{{0,0},{0,1},{0,2},{0,3}}, //19 4 2
		        {{0,0},{1,0},{2,0},{3,0}},
		        {{0,0},{1,0},{0,1},{1,1}},
		     //3
		        {{0,0},{0,1},{0,2},{1,0}}, //o
		        {{0,0},{1,0},{2,0},{2,1}}, //o
		        {{0,2},{1,2},{1,1},{1,0}}, //o
		        {{0,0},{0,1},{1,1},{2,1}}, //o
		        {{0,0},{1,0},{1,1},{1,2}}, //o
		        {{0,0},{0,1},{1,0},{2,0}}, //o
		        {{0,0},{0,1},{0,2},{1,2}}, //o
		        {{0,1},{1,1},{2,1},{2,0}}, 
		      //4
		        {{0,1},{0,2},{1,1},{1,0}}, //o
		        {{0,0},{1,0},{1,1},{2,1}}, //o
		        {{0,0},{0,1},{1,1},{1,2}}, //o
		        {{0,1},{1,1},{1,0},{2,0}}, //o
		        //5
		        {{0,0},{1,0},{2,0},{1,1}},  //o
		        {{0,0},{0,1},{1,1},{0,2}}, //o
		        {{1,0},{0,1},{1,1},{2,1}}, //o
		        {{1,0},{0,1},{1,1},{1,2}}, //o


		        };
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[][] = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int realresult = 0;
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				for(int j=0;j<19;j++) {
					int result = 0;
					for(int x=0;x<4;x++) {
						int x1 = i+tetris[j][x][0];
						int y1 = k+tetris[j][x][1];
						if(x1>=0&&y1>=0&&x1<N&&y1<M) {
							result = result + arr[x1][y1];
						}
						else {
							result = -1;
							break;
						}
					}
					if(result ==-1) {
						continue;
					}
					else {
						realresult = Math.max(result, realresult);
					}
				}
			}
		}
		System.out.println(realresult);
		
		
	}
}
