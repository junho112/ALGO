import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int arr[][];
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int k=0;k<9;k++) {
				arr[i][k] = str.charAt(k) - '0';
				if(arr[i][k]==0) {
					list.add(new int[] {i,k});
				}
			}
		}
		
		back(0);

	}

	private static void back(int def) {
		// TODO Auto-generated method stub
		if(def == list.size()) {
			print();
			System.exit(0);
			return;
		}
		int y = list.get(def)[0];
		int x = list.get(def)[1];
		
		boolean check[] = new boolean[10];
		
		for(int i=0;i<9;i++) {
			if(arr[y][i]!=0) {
				check[arr[y][i]] = true;
			}
			if(arr[i][x]!=0) {
				check[arr[i][x]] = true;
			}
		}
		int cy = (y/3)*3;
		int cx = (x/3)*3;
		
		for(int i=cy;i<cy+3;i++) {
			for(int k=cx;k<cx+3;k++) {
				if(arr[i][k]!=0) {
					check[arr[i][k]] = true;
				}
			}
		}
		for(int i=1;i<10;i++) {
			if(!check[i]) {
				arr[y][x] = i;
				back(def+1);
				arr[y][x] = 0;
			}
		}
		
	}

	private static void print() {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++) {
			for(int k=0;k<9;k++) {
				System.out.print(arr[i][k]);
			}
			System.out.println();
		}
	}

	static class Node{
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}