import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_7662_이중우선순위큐 {

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int test_case = 0; test_case<T;test_case++) {
        	TreeSet<Integer> tree = new TreeSet<>();
        	HashMap<Integer,Integer> map = new HashMap<>();
        	int num = Integer.parseInt(br.readLine());
        	for(int i=0;i<num;i++) {
        		st = new StringTokenizer(br.readLine());
        		String str = st.nextToken();
        		int tmp = Integer.parseInt(st.nextToken());
        		if(str.equals("I")) {
        			tree.add(tmp);
        			map.put(tmp, map.getOrDefault(tmp, 0)+1);
        		}
        		else {
        			if(!tree.isEmpty()) {
        				if(tmp==-1) {
        					int a = tree.pollFirst();
        					int cnt = map.get(a);
        					if(cnt>1) {
        						tree.add(a);
        						map.put(a, cnt-1);
        					}else {
        						map.put(a, 0);
        					}
        				}else {
        					int a = tree.pollLast();
        					int cnt = map.get(a);
        					if(cnt>1) {
        						tree.add(a);
        						map.put(a, cnt-1);
        					}else {
        						map.put(a, 0);
        					}
        				}
        			}
        		}
        	}
        	
        	if(tree.isEmpty()){
        		System.out.println("EMPTY");
        	}else {
        		System.out.println(tree.last()+" "+tree.first());
        	}
        	
        	tree.clear();
        	map.clear();
    	}
    }

}


