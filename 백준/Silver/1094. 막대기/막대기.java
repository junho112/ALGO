import java.util.Scanner;

public class Main{
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int result = 0;
		for(int i=0;i<7;i++) {
			if((a&(1<<i))>0)
				result++;
		}
		System.out.println(result);
	}
}
