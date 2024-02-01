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
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		int p1 = 0, p2 = 0, p3 = 0;
		// i, left, right 가 포인터 3개
		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				// 일단 조건에 부합하면 정답으로 올림
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					p1 = i;
					p2 = left;
					p3 = right;
				}
				// 근데 sum 이 0이다? 그냥 바로끝
				if (sum == 0) {
					System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
					System.exit(0);
				} else if (sum > 0) { // sum 이 0보다 크면 right를 당기고
					right--;
				} else { // sum이 0보다 작으면 left 를 당김
					left++;
				}
			}
		}

		System.out.println(arr[p1] + " " + arr[p2] + " " + arr[p3]);
	}
}