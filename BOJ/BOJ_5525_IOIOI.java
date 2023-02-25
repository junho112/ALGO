import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5525_IOIOI{

	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = Integer.parseInt(br.readLine());
		String str = br.readLine();
		List<Integer> list = new ArrayList<>();
		boolean flag = false;
		int tmp = 0;
		for(int i=0;i<len;i++) {
			if(!flag) {
				if(str.charAt(i)=='I') {
					flag = true;
					tmp++;
				}else {
					if(tmp>N) {
						list.add(tmp-1);
					}
					tmp = 0;
				}
			}else {
				if(str.charAt(i)=='O') {
					flag = false;
				}else {
					if(tmp>N) {
						list.add(tmp-1);
					}
					flag = true;
					tmp = 1;
				}
			}
		}
		if(tmp>N) {
			list.add(tmp-1);
		}
		int result = 0;
		for(int i=0;i<list.size();i++) {
			result = result + list.get(i)-N+1;
		}
		System.out.println(result);
	}
}
