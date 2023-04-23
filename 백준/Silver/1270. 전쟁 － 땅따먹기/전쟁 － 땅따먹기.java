import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test=1;test<=T;test++) {
			System.gc();
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<Long,Long> map = new HashMap<>();
			int N = Integer.parseInt(st.nextToken());
			boolean flag= false;
			for(int i=0;i<N;i++) {
				long tmp = Long.parseLong(st.nextToken());
				if(map.containsKey(tmp)) {
					map.put(tmp,map.get(tmp)+1);
				}else {
					map.put(tmp, (long) 1);
				}
				if(map.get(tmp)>N/2) {
					sb.append(tmp).append("\n");
					flag = true;
					break;
				}
			}
			if(!flag) {
				sb.append("SYJKGW").append("\n");
			}
			map.clear();
		}
		System.out.println(sb);
	}
}
