package algo;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		//N개
		//자를 때 드는 비용 :C  
		//한 단위의 가격 W 
		//길이 들 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long C = sc.nextInt();
		long w = sc.nextInt();
		long arr[] = new long[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);//정렬
		long result = 0;
		long realresult = 0;
		long tmp = 0;
		for(int i=1;i<=arr[N-1];i++) {//1 1 1 2
			result = 0;
			for(int k=0;k<N;k++) {
				int cutting = 0;
				if(arr[k]>=i) {
					if(arr[k]%i == 0) {
						cutting = (int) (arr[k]/i -1);
					}
					else {
						cutting = (int) (arr[k]/i);
					}
					if((arr[k]/i)*i*w-cutting*C>0) {
						result = result+(arr[k]/i)*i*w-cutting*C;
					}
				}
			}
			realresult = Math.max(realresult, result);
		}
		System.out.println(realresult);
	}
}	
