import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + M];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i < M; i++) {
				arr[N + i] = arr[i];
			}

			int[] prefixSum = new int[N + M];
			for (int i = 1; i < N + M; i++) {
				prefixSum[i] = prefixSum[i - 1] + arr[i];
			}

			int left = 0, right = M, answer = 0;
			if (N == M) {
				int money = prefixSum[N] - prefixSum[0];
				if (money < K)
					answer++;
			} else {
				while (right < (N + M)) {
					int money = prefixSum[right] - prefixSum[left];
					if (money < K)
						answer++;
					left++;
					right++;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}