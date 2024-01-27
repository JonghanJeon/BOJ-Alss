import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];
		}

		Map<Integer, Integer> mapA = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int x = A[i] - A[j];
				if (mapA.containsKey(x))
					mapA.replace(x, mapA.get(x) + 1);
				else
					mapA.put(x, 1);
			}
		}

		int M = Integer.parseInt(br.readLine());

		int[] B = new int[M + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			B[i] = Integer.parseInt(st.nextToken()) + B[i - 1];
		}

		Map<Integer, Integer> mapB = new HashMap<>();
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < i; j++) {
				int x = B[i] - B[j];
				if (mapB.containsKey(x))
					mapB.replace(x, mapB.get(x) + 1);
				else
					mapB.put(x, 1);
			}
		}

		long answer = 0;
		for (int keyA : mapA.keySet()) {
			int target = T - keyA;
			if (mapB.containsKey(target))
				answer += (long)mapA.get(keyA) * mapB.get(target);
		}

		System.out.println(answer);
	}
}