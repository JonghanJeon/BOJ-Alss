import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {

	static int N, K;
	static int[] students, names;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		students = new int[N+1];
		names = new int[21];
		Arrays.fill(names, 0);

		for (int i = 0; i < N; i++) {
			students[i] = br.readLine().length();
		}

		for (int i = 0; i <= K; i++) {
			names[students[i]]++;
		}

		long answer = names[students[0]] - 1;

		for (int i = 1; i < N; i++) {
			names[students[i - 1]]--;
			if ((i + K) < N) {
				names[students[i + K]]++;
			}

			answer += names[students[i]] - 1;
		}

		System.out.println(answer);

	}
}