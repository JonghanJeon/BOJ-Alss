import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[2 * N + 1];
		int[] tmp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			tmp[i] = Integer.parseInt(br.readLine());
			arr[i] = arr[i - 1] + tmp[i];
		}
		for (int i = 1; i <= N; i++) {
			arr[i + N] = arr[i + N - 1] + tmp[i];
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				int distance1 = arr[i + N] - arr[j];
				int distance2 = arr[j + N] - arr[i + N];
				int distance = Math.min(distance1, distance2);
				max = Math.max(distance, max);
			}
		}

		System.out.println(max);
	}
}