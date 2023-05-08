import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static char[][] arr;
	static int N;
	static boolean visit[][][];
	static int dy[] = {0,0,-1,1}; //4방탐색
	static int dx[] = {1,-1,0,0};
	static int roty[][] = {{0,0},{-1,1}}; // 0(가로)  1(세로) 날개 확인
	static int rotx[][] = {{-1,1},{0,0}}; // 0(가로)  1(세로)
	static int py[] = {-1,-1,-1,0,0,0,1,1,1}; //8방탐색
	static int px[] = {-1,0,1,-1,0,1,-1,0,1};

	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new boolean[N][N][2]; //3차원 방문배열을 이용해 0(가로)과 1(세로) 각각의 방문 처리하자 
		int by = 0; //B 의 중심 y좌표 
		int bx = 0; //B 의 중심 x좌표
		int ey = 0; //E 의 중심 y좌표
		int ex = 0; //E 의 중심 x좌표
		int bd = 0; //B가 세로 or 가로
		int ed = 0; //E가 세로 or 가로
		int bflag = 0; //B를 두번째 방문했을 때! 
		int eflag = 0; //E를 두번째 방문했을 때!
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<N;k++) {
				arr[i][k] = str.charAt(k);
				if(arr[i][k]=='B') {
					if(bflag==1) { // 2번째 방문 일때 y값이 다르면 세로로 서있다는 뜻임
						if(by==i) {
							bd = 0;
						}else{    // x값이 같을때는 가로
							bd = 1;
						}
					}
					by+=i;
					bx+=k;	
					bflag++;
				}else if(arr[i][k]=='E') { //B와 동일
					if(eflag==1) { //2번째 방문
						if(ey==i) {
							ed = 0;
						}else{
							ed = 1;
						}
					}
					ey+=i;
					ex+=k;
					eflag++;
				}
			}
		}
		by = by/3; bx = bx/3; ey = ey/3; ex=ex/3; //B와 E의 중심 좌표 찾기
		//3개의 좌표를 더했으니 3으로 나누면 중심좌표가 나온다
//		System.out.println(by+" "+bx+" "+ey+" "+ex+" "+bd+" "+ed);
		int result = bfs(by,bx,bd,ey,ex,ed); //BFS 시작
		System.out.println(result); // 결과값 추력
	}	
	private static int bfs(int by, int bx, int bd, int ey, int ex, int ed) {
		// TODO Auto-generated method stub
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(new Node(by,bx,bd,0));
		visit[by][bx][bd] = true;
		while(!mq.isEmpty()) {
			Node tmp = mq.poll();
//			System.out.println(tmp.y+" "+tmp.x+" "+tmp.d);
			if(tmp.y==ey&&tmp.x==ex&&tmp.d==ed) { //y좌표, x좌표, 방향이 일치한다면 출력
				return tmp.cnt;
			}
			for(int i=0;i<4;i++) { // 4방탐색 UDLR
				int cy = dy[i] + tmp.y;
				int cx = dx[i] + tmp.x;
//				System.out.println("돌기"+cy+" "+cx);
				if(check(cy,cx)&&arr[cy][cx]!='1') {
					if(!visit[cy][cx][tmp.d]) { //양 사이드의 날개쪽이 문제 없는지 확인
						int ry1 = cy+roty[tmp.d][0];
						int rx1 = cx+rotx[tmp.d][0];
						int ry2 = cy+roty[tmp.d][1];
						int rx2 = cx+rotx[tmp.d][1];
//						System.out.println(cy+" "+cx);
//						System.out.println(ry1+" "+rx1+" "+ry2+" "+rx2+" d:"+tmp.d);
						if(check(ry1,rx1)&&check(ry2,rx2)&&arr[ry1][rx1]!='1'&&arr[ry2][rx2]!='1') { //모두다 배열 범위 안쪽이고 1이 아닐때
							mq.add(new Node(cy,cx,tmp.d,tmp.cnt+1));
							visit[cy][cx][tmp.d] = true;//방문처리
						}
					}
				}
			}
			//방향전환 T
			int newd = (tmp.d+1)%2; //모듈러 연산을 이용해 0->1 or 1->0
			int cy = tmp.y;
			int cx = tmp.x;
			if(!visit[cy][cx][newd]) { //양 사이드의 날개쪽이 문제 없는지 확인
				
				boolean flag= true;
				for(int i=0;i<9;i++) { //8방 탐색을 하며 주위에 하나라도 1이 있으면 flag를 이용하여 다음 계산 넘어가기
					int yy = cy+py[i];
					int xx = cx+px[i];
					if(check(yy,xx)&&arr[yy][xx]!='1') {
						continue;
					}else {
						flag = false; //하나라도 조건미충족시 false
						break;
					}
				}
				if(flag) { //조건 충족, 배열 범위 체크,
					mq.add(new Node(cy,cx,newd,tmp.cnt+1));
					visit[cy][cx][newd] = true; //방문처리
				}
			}
		}
		//못찾았으면 0 return
		return 0;
	}
		
	static boolean check(int y,int x) { // 배열 범위 체크 함수 
		if(y>=0&&x>=0&&y<N&&x<N) return true;
		return false;
	}

	//queue에 들어갈 class 정의
	static class Node{
		int y; //y좌표
		int x; //x좌표
		int d; //1 -> 세로  0-> 가로
		int cnt; //얼마만큼 명령을 수행했는지 (결과값)
		public Node(int y, int x, int d, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.cnt = cnt;
		}
		
	}
}
