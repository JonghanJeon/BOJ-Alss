import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 1;
		int cnt = 0;
		while (true) {
			if (left == N || right == N + 1)
				break;

			if (left == right)
				right++;
			else {
				long sum = arr[right] - arr[left];
				if (sum == M) {
					cnt++;
					left++;
					right++;
				} else if (sum < M) {
					right++;
				} else {
					left++;
				}
			}
		}

		System.out.println(cnt);
	}
}