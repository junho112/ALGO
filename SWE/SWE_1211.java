package algo;

import java.util.Scanner;
import java.io.FileInputStream;


class SWE_1211{
	
	public static void main(String args[]) throws Exception{

		Scanner sc = new Scanner(System.in);
		int T =10 ;
		
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int arr[][] = new int[100][100];
			int startx = 0;
			for(int i=0;i<100;i++) {
				for(int k=0;k<100;k++) {
					arr[i][k] = sc.nextInt();
					if(i==99&&arr[i][k]==2) {
						startx=k;
					}
				}
			}
//			System.out.println(startx);
			int dy[] = {-1,0,0}; //올라가기, 왼쪽, 오른쪽
			int dx[] = {0,-1,1};
			int x=startx;
			int y=99;
			int d=0;
			while(y!=0) {
				//오른쪽
				if(x+1<100&&arr[y][x+1]==1&&d!=1) {
					d=2;
				}
				//왼쪽
				if(x-1>=0&&arr[y][x-1]==1&&d!=2) {
					d=1;
				}
				
				int tx = x+dx[d];
				int ty = y+dy[d];
				if(tx>=100 || tx<0 || ty>=100 || ty<0 || arr[ty][tx]==0){
					d=0; //올라가기
					ty = y+dy[d];
					tx = x+dx[d];
				}
				x = tx;
				y = ty;
			}
			System.out.println("#"+test_case+" "+x);
		}
	}
}

