import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759_암호만들기 {
//	static int cnt;
	static int L;
	static int C;
	static char arr[];
	static char result[];
	static char moum[] = new char[] {'a','e','i','o','u'};
	static boolean moumcheck[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] argrs) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new char[C];
		result = new char[L];
		moumcheck = new boolean[C];
		for(int i=0;i<C;i++) {
			String a = sc.next();
			arr[i] = a.charAt(0);
		}
		Arrays.sort(arr);
		for(int i=0;i<C;i++) {
			for(int k=0;k<5;k++) {
				if(arr[i]==moum[k]) {
					moumcheck[i] =true;//모음임 
				}
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(moumcheck));
		back(0,0,0,0);
		System.out.println(sb);
//		System.out.println(cnt);
	
	}
	private static void back(int def,int len,int m,int z) {
		// TODO Auto-generated method stub
		if (def == L) {
			if(m>=1&&z>=2){
				for(int i=0;i<L-1;i++) {
					sb.append(result[i]);
				}
				sb.append(result[L-1]);
				sb.append("\n");
			}
			return;
		}
		for(int k=len;k<C;k++) {
				result[def] = arr[k];
				if(moumcheck[k]) {
					back(def+1,k+1,m+1,z); //모음일때
				}
				else {
					back(def+1,k+1,m,z+1); // 자음일때
				}
			}
		}
	
}
