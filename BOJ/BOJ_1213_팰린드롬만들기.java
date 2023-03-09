import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1213_팰린드롬만들기{
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int arr[] = new int[26];
		for(int i=0;i<str.length();i++) {
			arr[str.charAt(i)-'A']++;
		}
		char result[] = new char[str.length()];
		String error = "I'm Sorry Hansoo";
		int len = str.length();
		int start = 0;
		int end = str.length()-1;
		int flag = 0;
		while(start<=end) {
			boolean a = false;
			for(int i=0;i<26;i++) {
				if(arr[i]>=2 &&!a) {
					result[start] = (char) (i+'A');
					result[end] = (char) (i+'A');
					start++;
					end--;
					arr[i] = arr[i]-2;
					a=true;
					break;
				}
				
			}
			if(a) {
				continue;
			}
			if(start==end) {
				for(int i=0;i<26;i++) {
					if(arr[i]==1) {
						result[start] = (char) (i+'A');
						a=true;
						break;
					}
				}
				if(a) break;
				flag = 1;
				break;
			}else {
				flag = 1;
				break;
			}
		}
		if(flag == 1) {
			System.out.println(error);
		}else {
			for(int i=0;i<str.length();i++) {
				System.out.print(result[i]);
			}
		}
	}
}
