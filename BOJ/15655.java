import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static int arr[];
	static int N;
	static int M;
	static boolean visit[];
	static int save[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		save = new int[N];
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		back(0);
	}
	
	public static void back(int def) {
		if(def==M) {
			for(int k=0;k<M;k++) {
				System.out.print(save[k]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				if(def==0) {
					save[def] = arr[i];
					back(def+1);
				}
				else if(save[def-1]<arr[i]) {
					save[def] = arr[i];
					back(def+1);
				}
			}
		}
	}
}	
