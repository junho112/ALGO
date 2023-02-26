import java.util.Scanner;

public class BOJ_1541_연산자끼워넣기{
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int sum = Integer.MAX_VALUE;
		String[] sub = sc.nextLine().split("-");
		
		for(int i=0;i<sub.length;i++) {
			int tmp = 0;
			String[] add = sub[i].split("\\+"); // + 출력 주의 하기 
			
			for(int k=0;k<add.length;k++) {
				tmp = tmp + Integer.parseInt(add[k]);
			}
			if(sum== Integer.MAX_VALUE) {
				sum = tmp;
			}else {
				sum = sum-tmp;
			}
		}
		System.out.println(sum);
	}
}
