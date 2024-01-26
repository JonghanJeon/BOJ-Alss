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
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());
		}
		int totalDistance = arr[N];
		int halfDistance = totalDistance / 2;

		int left = 1, right = 2;
		int answer = 0;
		while (left < right && right <= N) {
			int distance = arr[right] - arr[left];
			if (distance < halfDistance) {
				answer = Math.max(distance, answer);
				right++;
			} else if (distance > halfDistance) {
				distance = totalDistance - distance;
				answer = Math.max(distance, answer);
				left++;
			} else {
				System.out.println(distance);
				return;
			}
		}

		System.out.println(answer);
	}
}