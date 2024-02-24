import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static final int[][] direct = {
		{1, 0},
		{-1, 0},
		{0, 1},
		{0, -1}
	};
	static int R, C, answer;
	static char[][] board;
	static boolean[] visited = new boolean[26];
	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = 0;
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		visited[board[0][0] - 'A'] = true;
		DFS(1, 0, 0);

		System.out.println(answer);
	}

	static void DFS(int depth, int row, int col) {
		answer = Math.max(depth, answer);

		for (int i = 0; i < 4; i++) {
			int dCol = direct[i][1];
			int dRow = direct[i][0];

			int nextRow = row + dRow;
			int nextCol = col + dCol;

			if (!isOutOfBounds(nextRow, nextCol)) {
				if (!visited[board[nextRow][nextCol] - 'A']) {
					// 갈 수 있으면
					visited[board[nextRow][nextCol] - 'A'] = true;
					DFS(depth + 1, nextRow, nextCol);
					//RECOVERY
					visited[board[nextRow][nextCol] - 'A'] = false;
				}
			}
		}
	}

	static boolean isOutOfBounds(int row, int col) {
		return !(0 <= row && row < R && 0 <= col && col < C);
	}
}