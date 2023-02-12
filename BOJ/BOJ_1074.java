import java.util.Scanner;

public class BOJ_1074 {
	static int arr[][];
	static int num = 0;
	static int r;
	static int c;
	static int result = 0;
	public static void main(String[] argrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt()+1;
		c = sc.nextInt()+1;
		
		int N2 = (int) Math.pow(2, N);
//		arr = new int[N2][N2];
		zPro(N,N2,N2);
		System.out.println(result);
	}
	
	public static void zPro(int n, int x,int y) {//8,8
		if(n == 1) {
			//저장
			if((y-1)==r&&(x-1)==c) result=num++;
			else num++;
			if((y-1)==r&&(x-0)==c) result=num++;
			else num++;
			if((y-0)==r&&(x-1)==c) result=num++;
			else num++;
			if((y-0)==r&&(x-0)==c) result=num++;
			else num++;

			return; 
		}
		int tmp = (int) Math.pow(2, n-1);
		if(r>y-tmp-tmp&&r<=y-tmp&&c>x-tmp-tmp&&c<=x-tmp) {
			zPro(n-1,x-tmp,y-tmp); //1사분면
		}
		else if(r>y-tmp-tmp&r<=y-tmp&&c>x-tmp&&c<=x) {
			num = (int) (num + Math.pow(2, n-1)*Math.pow(2, n-1));
			zPro(n-1,x,y-tmp);   //2사분면
		}
		else if(r>y-tmp&r<=y&&c>x-tmp-tmp&&c<=x-tmp) {
			num = (int) (num + Math.pow(2, n-1)*Math.pow(2, n-1)*2);
			zPro(n-1,x-tmp,y);   //3사분면
		}
		else if(r>y-tmp&r<=y&&c>x-tmp&&c<=x) {
			num = (int) (num + Math.pow(2, n-1)*Math.pow(2, n-1)*3);
			zPro(n-1,x,y);     //4사분면
		}
		
	}
}
