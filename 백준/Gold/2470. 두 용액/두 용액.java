import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0, right = arr.length - 1;
		int sum = Math.abs(arr[left] + arr[right]);
		int answerLeftIndex = 0;
		int answerRightIndex = arr.length - 1;

		while (left < right) {
			int result = arr[left] + arr[right];
			if (Math.abs(result) < Math.abs(sum)) {
				sum = result;
				answerLeftIndex = left;
				answerRightIndex = right;
			}
			if (result < 0) {
				left++;
			} else if (0 < result) {
				right--;
			} else if (result == 0) {
				answerLeftIndex = left;
				answerRightIndex = right;
				break;
			}
		}

		// 2. 결과를 오름차순으로 출력
		System.out.printf("%d %d", arr[answerLeftIndex], arr[answerRightIndex]);
	}
}