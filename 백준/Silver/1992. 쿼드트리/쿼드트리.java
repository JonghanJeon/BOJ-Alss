import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {

	static int N;
	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		quadTree(0, 0, N);

		System.out.println(sb);
	}

	public static void quadTree(final int row, final int col, final int size) {

		if (isPossible(row, col, size)) {
			sb.append(board[row][col]);
			return;
		}

		int newSize = size / 2;

		sb.append("(");

		//좌상
		quadTree(row, col, newSize);
		//우상
		quadTree(row, col + newSize, newSize);
		//좌하
		quadTree(row + newSize, col, newSize);
		//우하
		quadTree(row + newSize, col + newSize, newSize);

		sb.append(")");
	}

	public static boolean isPossible(final int x, final int y, final int size) {
		int value = board[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (board[i][j] != value) {
					return false;
				}
			}
		}

		return true;
	}
}