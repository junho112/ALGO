import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int arr[] = new int[6];
		int arr2[] = new int[6];
		int arr3[][] = new int[2][3];
		int min1 = 0;
		int min2 = 0;
		int j=0;
		int k=0;
		for(int i=0;i<6;i++) {
			arr[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
			if(arr[i]<3) {
				arr3[0][k] = arr2[i];
				k++;
			}
			else {
				arr3[1][j] = arr2[i];
				j++;
			}
		}
		for(int i=0;i<5;i++) {
			if(arr[i]==4&&arr[i+1]!=2) {
				min1 = arr2[i];
				min2 = arr2[i+1];
				break;
			}
			else if(arr[i]==2&&arr[i+1]!=3) {
				min1 = arr2[i];
				min2 = arr2[i+1];
				break;
			}
			else if(arr[i]==3&&arr[i+1]!=1) {
				min1 = arr2[i];
				min2 = arr2[i+1];
				break;
			}
			else if(arr[i]==1&&arr[i+1]!=4) {
				min1 = arr2[i];
				min2 = arr2[i+1];
				break;
			}
		}
		
		if(arr[5]==4&&arr[0]!=2) {
			min1 = arr2[5];
			min2 = arr2[0];
			
		}
		else if(arr[5]==2&&arr[0]!=3) {
			min1 = arr2[5];
			min2 = arr2[0];
			
		}
		else if(arr[5]==3&&arr[0]!=1) {
			min1 = arr2[5];
			min2 = arr2[0];
			
		}
		else if(arr[5]==1&&arr[0]!=4) {
			min1 = arr2[5];
			min2 = arr2[0];
			
		}
		int maxX = Math.max(Math.max(arr3[0][0],arr3[0][1]),arr3[0][2]);
		int maxY = Math.max(Math.max(arr3[1][0],arr3[1][1]),arr3[1][2]);
		
		
		System.out.println((maxX*maxY-min1*min2)*a);
	}
	
	
}

