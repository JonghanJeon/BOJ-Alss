import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 1, right = N * 10000, answer = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int diskCnt = getDiskCnt(mid);
			if (diskCnt <= M) {
				answer = mid;
				right = mid - 1;
			} else
				left = mid + 1;
		}

		System.out.println(answer);
	}

	public static int getDiskCnt(int upperLimit) {
		int cnt = 1;
		int currentLength = 0;
		for (int len : arr) {
			if (len > upperLimit)
				return 100001;
			if (currentLength + len > upperLimit) {
				currentLength = 0;
				cnt++;
			}
			currentLength += len;
		}
		return cnt;
	}
}