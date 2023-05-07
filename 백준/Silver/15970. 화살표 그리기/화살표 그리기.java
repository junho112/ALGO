import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}
		for(int i=0;i<=N;i++) {
			Collections.sort(list.get(i));
		}
		int result = 0;
		for(int i=1;i<=N;i++) {
			for(int k=0;k<list.get(i).size();k++) {
				if(k==0) {
					result=result+list.get(i).get(k+1)-list.get(i).get(k);
				}else if(k==list.get(i).size()-1) {
					result=result+list.get(i).get(k)-list.get(i).get(k-1);
				}else {
					int res = Math.min(list.get(i).get(k+1)-list.get(i).get(k), list.get(i).get(k)-list.get(i).get(k-1));
					result = result+res;
				}
			}
		}
		System.out.println(result);
	}
}