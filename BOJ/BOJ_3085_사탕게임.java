import java.util.Scanner;

public class BOJ_3085_사탕게임 {
	static int dy[] = {-1,1,0,0};//상하좌우
	static int dx[] = {0,0,-1,1};
	static int arr[][];
	static int N;
	static int maxCandy = 0;
	public static void main(String[] agrs)  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int k=0;k<N;k++) {
				char ch = tmp.charAt(k);
				if(ch=='C') {
					arr[i][k] = 1;
				}else if(ch=='P') {
					arr[i][k] = 2;
				}else if(ch=='Z') {
					arr[i][k] = 3;
				}else if(ch=='Y') {
					arr[i][k] = 4;
				}
			}
		}//for end

		
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				for(int j=0;j<4;j++) {
					int cy = dy[j]+i;
					int cx = dx[j]+k;
					if(cy>=0&&cx>=0&&cy<N&&cx<N&&arr[i][k]!=arr[cy][cx]) {
						int tmp = arr[i][k];
						arr[i][k] = arr[cy][cx];
						arr[cy][cx] = tmp;

						mCandy();
						arr[cy][cx] = arr[i][k];
						arr[i][k] = tmp;
					}
				}
			}
		}
		System.out.println(maxCandy);
	}
	private static void mCandy() {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			int tmp = 1;
			for(int k=1;k<N;k++) {
				if(arr[i][k]==arr[i][k-1]) {
					tmp++;
					maxCandy = Math.max(tmp, maxCandy);
				}
				else {
					tmp = 1;
				}
			}
		}
		for(int i=0;i<N;i++) {
			int tmp = 1;
			for(int k=1;k<N;k++) {
				if(arr[k][i]==arr[k-1][i]) {
					tmp++;
					maxCandy = Math.max(tmp, maxCandy);
				}
				else {
					tmp = 1;
				}
			}
		}
	}
	
	
	
	//최대 개 수 구하기 
}
