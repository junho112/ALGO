package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15656 {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] save;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		save = new int[M]; 
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		back(0);
		System.out.println(sb);
	}//1 2 3 4
	public static void back(int def) {
		if(def==M) {
			for(int j=0;j<M;j++) {
				sb.append(save[j]+" ");
			}
			sb.append("\n");
			return ;
		}
		for(int i=0;i<N;i++) {
			if(def==0) {
				save[def] = arr[i];
				back(def+1);
			}
			else {

					save[def] = arr[i];
					back(def+1);
				
			}
		}
	}
}
