import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int result[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			result[i] = i + 1;
		}
		long sum = 0;
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			sum = sum + Math.abs(arr[i] - result[i]);
		}
		System.out.println(sum);
	}
}
