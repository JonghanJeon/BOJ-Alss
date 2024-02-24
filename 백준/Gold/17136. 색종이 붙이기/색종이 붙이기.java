import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.swing.*;

public class Main {

	static int[][] board = new int[10][10];
	static int[] squareCnt = {0, 5, 5, 5, 5, 5};
	static int min = -1;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0, 0, 0);

		System.out.println(min);
	}

	static void DFS(int x, int y, int depth) {
		if (y > 9) {
			DFS(x + 1, 0, depth);
			return;
		}

		if (x > 9) {
			if (min == -1)
				min = depth;
			else if (min > depth)
				min = depth;
			return;
		}

		if (board[x][y] == 0) {
			DFS(x, y + 1, depth);
			return;
		}

		for (int s = 5; s >= 1; s--) {

			//해당 색종이가 남아있고, 사이즈가 벗어나지 않는다면
			if (squareCnt[s] != 0 && x + s <= 10 && y + s <= 10) {

				//정사각형이 된다면
				if (isSquare(x, y, s)) {

					checkSquare(x, y, s, true);

					DFS(x, y + s, depth + 1);

					checkSquare(x, y, s, false);
				}
			}
		}

	}

	static void checkSquare(int r, int c, int s, boolean useSquare) {
		if (useSquare) {
			squareCnt[s]--;
			for (int i = 0; i < s; i++) {
				for (int j = 0; j < s; j++) {
					board[r + i][c + j] = 0;
				}
			}
		} else {
			squareCnt[s]++;
			for (int i = 0; i < s; i++) {
				for (int j = 0; j < s; j++) {
					board[r + i][c + j] = 1;
				}
			}
		}
	}

	static boolean isSquare(int x, int y, int s) {
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				if (board[x + i][y + j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}