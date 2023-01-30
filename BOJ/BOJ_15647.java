import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15647 {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] save;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//중복 가능 오름차순 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 st = new StringTokenizer(br.readLine());
		 arr = new int[N];
		 save = new int[M];
		 for(int i=0;i<N;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 Arrays.sort(arr);
		 back(0,0);
		 System.out.println(sb);
	}
	public static void back(int def,int w) {
		if(def == M) {
			//save 출력
			for(int k=0;k<M;k++) {
				sb.append(save[k]+" ");
			}
			sb.append("\n");
			return ;
		}
		for(int i=w;i<N;i++) {
			save[def] = arr[i];
			back(def+1,i);
			
		}
	}
}
