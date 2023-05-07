import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int size = 2;
	static int eat = 0;
	static int time = 0;
	static int arr[][];
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		Queue<Node> mq = new ArrayDeque<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0;k<N;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if(arr[i][k]==9) {
					mq.add(new Node(i,k,0));
					arr[i][k] = 0;
				}
			}
		}
		
		while(true) {
			ArrayList<Node> fish = new ArrayList<>();
			int visit[][] = new int[N][N];
			
			while(!mq.isEmpty()) {
				Node tmp = mq.poll();
				
				for(int i=0;i<4;i++) {
					int cy = tmp.y+dy[i];
					int cx = tmp.x+dx[i];
					if(cy>=0&&cx>=0&&cy<N&&cx<N&&visit[cy][cx]==0&&arr[cy][cx]<=size) {
						visit[cy][cx] = visit[tmp.y][tmp.x]+1;
						mq.add(new Node(cy,cx,visit[cy][cx]));
						if(arr[cy][cx]>=1&&arr[cy][cx]<=6&&arr[cy][cx]<size) {
							fish.add(new Node(cy,cx,visit[cy][cx]));
						}
					}
				}
			}
			if(fish.size()==0) {
				System.out.println(time);
				return;
			}
			
			Node tmpfish = fish.get(0);
			for(int i=1;i<fish.size();i++) {
				if(tmpfish.d>fish.get(i).d) {
					tmpfish = fish.get(i);
				}
				else if(tmpfish.d==fish.get(i).d) {
					if(tmpfish.y>fish.get(i).y) {
						tmpfish = fish.get(i);
					}else if(tmpfish.x==fish.get(i).x) {
						if(tmpfish.x>fish.get(i).x) {
							tmpfish = fish.get(i);
						}
					}
				}
			}
			time = time+tmpfish.d;
			eat++;
			arr[tmpfish.y][tmpfish.x] = 0;
			if(eat==size) {
				size++;
				eat = 0;
			}
			mq.add(new Node(tmpfish.y,tmpfish.x,0));
		}
		
	}
	
	static class Node{
		int y;
		int x;
		int d;
		public Node(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
}
