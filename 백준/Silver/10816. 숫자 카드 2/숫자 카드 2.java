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
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int result = findLastIndex(target) - findFirstIndex(target);
			sb.append(result).append(" ");
		}

		System.out.println(sb);
	}

	public static int findLastIndex(int target) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] <= target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return left;
	}

	public static int findFirstIndex(int target) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if(target <= arr[mid])
				right = mid -1;
			else
				left = mid + 1;
		}
		return left;
	}
}