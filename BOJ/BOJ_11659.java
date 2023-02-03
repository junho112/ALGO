package algo;

import java.util.Scanner;

public class BOJ_11659 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N+1];
		StringBuilder sb = new StringBuilder();
		arr[0] = 1;
		for(int i=1;i<=N;i++) {
			arr[i] = arr[i-1]+sc.nextInt();
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result = arr[b]-arr[a-1];
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
