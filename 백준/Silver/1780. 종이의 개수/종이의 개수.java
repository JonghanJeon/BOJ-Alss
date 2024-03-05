import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {

	static int N, a, b, c;
	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Character.getNumericValue(arr[j].charAt(0));
			}
		}

		a = 0;
		b = 0;
		c = 0;

		countPaper(0, 0, N);

		sb.append(a).append("\n").append(b).append("\n").append(c);
		System.out.println(sb);
	}

	static void countPaper(final int row, final int col, final int size) {

		if (isPossible(row, col, size)) {
			addPaper(row, col);
			return;
		}

		int newSize = size / 3;

		next(row, col, newSize);
	}

	private static void next(int row, int col, int newSize) {
		//좌상
		countPaper(row, col, newSize);
		//중상
		countPaper(row, col + newSize, newSize);
		//우상
		countPaper(row, col + newSize + newSize, newSize);
		//좌중
		countPaper(row + newSize, col, newSize);
		//중중
		countPaper(row + newSize, col + newSize, newSize);
		//우중
		countPaper(row + newSize, col + newSize + newSize, newSize);
		//좌하
		countPaper(row + newSize + newSize, col, newSize);
		//중하
		countPaper(row + newSize + newSize, col + newSize, newSize);
		//우하
		countPaper(row + newSize + newSize, col + newSize + newSize, newSize);
	}

	private static void addPaper(int row, int col) {
		if (board[row][col] == -1) {
			a++;
		} else if (board[row][col] == 0) {
			b++;
		} else if (board[row][col] == 1) {
			c++;
		}
	}

	static boolean isPossible(final int row, final int col, final int size) {
		int value = board[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (board[i][j] != value) {
					return false;
				}
			}
		}

		return true;
	}
}