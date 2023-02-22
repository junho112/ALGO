import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {
	/*
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
	 * 
	 * 
	 */
	static char[] move = {'^','>','v','<'}; //위 오른쪽 아래 왼
	static int dy[] = {-1,0,1,0};
	static int dx[] = {0,1,0,-1};
	static int H,W;
	static char[][] map;
	static int y,x;
	static int cy1,cx1;
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test = 1;test<=t;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i=0;i<H;i++) {
				String str = br.readLine();
				for(int k=0;k<W;k++) {
					map[i][k] = str.charAt(k);
					for(int j=0;j<4;j++) {
						if(map[i][k]==move[j]) { //탱크 저장
							y = i;
							x = k;
						}
					}
				}
			}
			int num = Integer.parseInt(br.readLine());
			String command = br.readLine();
			for(int i=0;i<num;i++) {
				function(command.charAt(i));
			}
			sb.append("#").append(test).append(" ");
			for(int i=0;i<H;i++) {
				for(int k=0;k<W;k++) {
					sb.append(map[i][k]);
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
	private static void function(char ch) {
		// TODO Auto-generated method stub
		if(ch=='U') {
			map[y][x] = move[0]; // 방향 바꾸기
			int cy = y-1; //한칸 위
			int cx = x;
			if(cy>=0&&cx>=0&&cy<H&&cx<W&&map[cy][cx]=='.') {
				map[y][x] = '.';
				map[cy][cx] = move[0];
				y = cy;
				x = cx;
			}
		}else if(ch=='D') {
			map[y][x] = move[2]; // 방향 바꾸기
			int cy = y+1; //한칸 위
			int cx = x;
			if(cy>=0&&cx>=0&&cy<H&&cx<W&&map[cy][cx]=='.') {
				map[y][x] = '.';
				map[cy][cx] = move[2];
				y = cy;
				x = cx;
			}
		}else if(ch=='L') {
			map[y][x] = move[3]; // 방향 바꾸기
			int cy = y; //한칸 위
			int cx = x-1;
			if(cy>=0&&cx>=0&&cy<H&&cx<W&&map[cy][cx]=='.') {
				map[y][x] = '.';
				map[cy][cx] = move[3];
				y = cy;
				x = cx;
			}
		}else if(ch=='R') {
			map[y][x] = move[1]; // 방향 바꾸기
			int cy = y; //한칸 위
			int cx = x+1;
			if(cy>=0&&cx>=0&&cy<H&&cx<W&&map[cy][cx]=='.') {
				map[y][x] = '.';
				map[cy][cx] = move[1];
				y = cy;
				x = cx;
			}
		}else { //shoot
			int check=0;
			for(int i=0;i<4;i++) {
				if(map[y][x]==move[i]) {
					check=i;
				}
			}
			cy1 = y+dy[check];
			cx1 = x+dx[check];
			boolean flag = true;;
			while(flag) {
				if(cy1>=0&&cx1>=0&&cy1<H&&cx1<W&&map[cy1][cx1]=='*') {
					map[cy1][cx1] = '.';
					flag = false;
				}
				else if(cy1>=0&&cx1>=0&&cy1<H&&cx1<W&&map[cy1][cx1]=='#') {
					flag = false;
				}
				else if(cy1>=0&&cx1>=0&&cy1<H&&cx1<W&&map[cy1][cx1]=='.') {

				}else if(cy1>=0&&cx1>=0&&cy1<H&&cx1<W&&map[cy1][cx1]=='-') {

				}
				else {
					flag = false;
				}
				cy1 = cy1+dy[check];
				cx1 = cx1+dx[check];
				
			}
		}
	}

}
//{

//}
