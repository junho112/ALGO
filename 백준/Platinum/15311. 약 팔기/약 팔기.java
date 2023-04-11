import java.util.Scanner;

public class Main {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[2000];
		for(int i=0;i<1000;i++) {
			arr[i] = 1;
		}
		for(int i=1000;i<2000;i++) {
			arr[i] = 1000;
		}
		System.out.println(2000);
		for(int i=0;i<2000;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
