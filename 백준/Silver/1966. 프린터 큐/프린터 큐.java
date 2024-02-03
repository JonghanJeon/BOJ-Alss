import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Deque<Integer> deque = new LinkedList<>();
			Deque<Integer> checking = new LinkedList<>();
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int number = Integer.parseInt(st.nextToken());
				arr[j] = number;
				deque.offer(number);
				checking.offer(j);
			}
			Arrays.sort(arr);
			reverseArray(arr);

			int cnt = 0;
			for (int j = 0; j < N; j++) {
				int number = arr[j];
				int item = deque.pollFirst();
				int checkItem = checking.pollFirst();
				if (item != number) {
					deque.offer(item);
					checking.offer(checkItem);
					j--;
					continue;
				} else {
					if (checkItem == M) {
						cnt++;
						sb.append(cnt).append("\n");
					} else
						cnt++;
				}
			}
		}
		System.out.println(sb);
	}

	public static void reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}
}