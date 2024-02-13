import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.imageio.plugins.tiff.TIFFTag;

public class Main {

	static int[] numbers;
	static int[] printNumbers;
	static boolean[] visited;
	static int N;
	static int M;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		visited = new boolean[N];
		printNumbers = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		backTracking(0,0);

	}

	static void backTracking(int startIdx, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(printNumbers[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = startIdx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				printNumbers[depth] = numbers[i];
				backTracking(i + 1,depth + 1);
				visited[i] = false;
			}
		}
	}
}