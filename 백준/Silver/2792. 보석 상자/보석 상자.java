import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M];

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int left = 1, right = Arrays.stream(arr).max().getAsInt();
		while (left <= right) {
			int mid = (left + right) / 2;

			// sum = 몫 = 사람 수
			int sum = 0;
			for (int x : arr) {
				sum += x / mid;
				if (x % mid > 0)
					sum ++;
			}

			// 결과 : 분산 => sum(사람수) 가 N 에 가까워 져야 한다. => 인당 개수를 줄여야 한다.
			if (sum <= N)
				right = mid - 1;
			else
				left = mid + 1;
		}

		System.out.println(left);
	}
}