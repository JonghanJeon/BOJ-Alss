import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < N; testCase++) {

			char[] arr = br.readLine().toCharArray();

			// 왼쪽꺼 지워보기
			int left = 0, right = arr.length - 1;
			int cnt = 0;
			while (left < right) {
				if (arr[left] == arr[right]) {
					left++;
					right--;
				} else {
					if (cnt == 1) {
						cnt = 2;
						break;
					}
					if (arr[left + 1] == arr[right]) {
						left++;
						cnt = 1;
					} else {
						cnt = 2;
						break;
					}
				}

			}

			left = 0;
			right = arr.length - 1;
			int cnt2 = 0;
			while (left < right) {
				if (arr[left] == arr[right]) {
					left++;
					right--;
				} else {
					if (cnt2 == 1) {
						cnt2 = 2;
						break;
					}
					if (arr[left] == arr[right - 1]) {
						right--;
						cnt2 = 1;
					} else {
						cnt2 = 2;
						break;
					}
				}

			}

			if (Math.min(cnt, cnt2) == 1)
				sb.append(1).append("\n");
			else if (Math.min(cnt, cnt2) == 2)
				sb.append(2).append("\n");
			else
				sb.append(0).append("\n");

		}

		System.out.println(sb);
	}
}