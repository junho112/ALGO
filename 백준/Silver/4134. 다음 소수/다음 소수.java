import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			String 	str = sc.next();
			BigInteger b1 = new BigInteger(str);
			if(b1.isProbablePrime(10)) {
				System.out.println(b1.toString());
			}else {
				System.out.println(b1.nextProbablePrime());
			}
		}
		
	}
}