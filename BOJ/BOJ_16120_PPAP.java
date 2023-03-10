import java.util.Scanner;
import java.util.Stack;

public class BOJ_16120_PPAP{
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='P') {
				st.add('P');
			}else {
				if(st.size()<2) {
					System.out.println("NP");
					return;
				}
				int a = st.pop();
				int b = st.pop();
				if(a!='P'||b!='P') {
//					System.out.println(111);
					System.out.println("NP");
					return;
				}else { // 둘다 p 일때 
					if(i==str.length()-1) {
//						System.out.println(22);

						System.out.println("NP");
						return;
					}else {
						if(str.charAt(i+1)=='A') {
//							System.out.println(333);

							System.out.println("NP");
							return;
						}
						else {
							st.add('P');
							i=i+1;
						}
					}
				}
			}
		}
//		System.out.println(st);
		if(st.size()==1&&st.pop()=='P') {
			System.out.println("PPAP");
		}else {
			System.out.println("NP");
		}
	}
}
