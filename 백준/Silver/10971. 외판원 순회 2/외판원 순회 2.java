import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[][] W;
	static boolean[] visited;
	static long answer;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		answer = Long.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= N; i++) {
			TSP(1, i, i, 0);
		}

		System.out.println(answer);
	}

	static void TSP(int depth, int startCityIdx, int currentCityIdx, long cost) {
		if (depth == N) {
			if (W[currentCityIdx][startCityIdx] != 0) {
				answer = Math.min(answer, cost + W[currentCityIdx][startCityIdx]);
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (i == startCityIdx || visited[i] || W[currentCityIdx][i] == 0) {
				continue;
			}
			visited[i] = true;
			TSP(depth + 1, startCityIdx, i, cost + W[currentCityIdx][i]);

			visited[i] = false;
		}
	}

}