import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] board;
	public static int[][] prefixSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int left = 0, right = k;
		while (left <= right) {
			int mid = (left + right) / 2;
			//개수
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if ((mid/i) >= N) {
					count += N;
				} else {
					count += mid / i;
				}
			}
			//조절
			if (k <= count) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(left);
	}
}