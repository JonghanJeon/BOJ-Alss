import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 입국 심사대 개수
		long M = Long.parseLong(st.nextToken()); // 사람 수
		long result = Long.MAX_VALUE;
		long[] arr = new long[N]; // 각 입국 심사대 마다 걸리는 시간
		long max = Long.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(arr[i], max);
		}

		long left = 0, right = M * max;
		while (left <= right)  {
			long mid = (left + right) / 2;
			long sum = 0;
			for (long i : arr) {
				long count = mid / i; // 각 입국 심사대에서 맡을 수 있는 사람 수
				sum += count;
				if (sum >= M) { // 사람 수 보다 많아 지면 break;
					break;
				}
			}

			if (M <= sum) { // 볼 수 있는 사람 수가 많거나 같다 -> 시간을 줄일 수 있음.
				right = mid - 1;
			} else { // 볼 수 있는 사람 수가 적다 -> 시간을 늘려야 함.
				left = mid + 1;
			}
		}

		System.out.println(left);
	}
}