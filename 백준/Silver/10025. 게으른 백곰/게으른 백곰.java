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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) * 2 + 1;

		int[] cage = new int[1_000_001];
		Arrays.fill(cage, 0);
		int maxIdx = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			maxIdx = Math.max(maxIdx, x);
			cage[x] = g;
		}

		long sum = 0;
		long answer = 0;
		for (int i = 0; i <= 1_000_000; i++) {
			if(i - K >= 0)
				sum -= cage[i - K];
			sum += cage[i];
			answer = Math.max(sum, answer);
		}

		System.out.println(answer);
	}
}