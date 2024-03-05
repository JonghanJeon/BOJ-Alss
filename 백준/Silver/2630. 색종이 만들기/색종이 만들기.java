import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {

	static int N, WHITE, BLUE;
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
				board[i][j] = arr[j].charAt(0) - '0';
			}
		}

		makeColorPaper(0, 0, N);
		sb.append(WHITE).append("\n").append(BLUE);
		System.out.println(sb);
	}

	public static void makeColorPaper(final int row, final int col, final int size) {
		//모두 같은 색이라면
		if (isPossible(row, col, size)) {
			if (board[row][col] == 1) {
				BLUE++;
			} else {
				WHITE++;
			}
			return;
		}

		//모두 같은 색이 아니라면
		int newSize = size / 2;

		//좌상
		makeColorPaper(row, col, newSize);
		//우상
		makeColorPaper(row, col + newSize, newSize);
		//좌하
		makeColorPaper(row + newSize, col, newSize);
		//우하
		makeColorPaper(row + newSize, col + newSize, newSize);
	}

	/**
	 * 모두 같은 색인지 체크
	 * @param row 시작 row
	 * @param col 시작 col
	 * @param size 종이 한 변의 길이
	 * @return 모두 같은 색이라면 true 아니면 false
	 */
	public static boolean isPossible(final int row, final int col, final int size) {
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