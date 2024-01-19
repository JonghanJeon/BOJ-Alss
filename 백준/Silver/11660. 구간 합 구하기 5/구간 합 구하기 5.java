import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N + 1][N + 1];
		int sum = 0;

		for (int row = 1; row <= N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= N; col++) {
				sum += Integer.parseInt(st.nextToken());
				board[row][col] = sum;
			}
		}

		for (int row = 1; row <= N; row++) {
			board[row][0] = board[row - 1][N];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startRow = Integer.parseInt(st.nextToken());
			int startCol = Integer.parseInt(st.nextToken());
			int endRow = Integer.parseInt(st.nextToken());
			int endCol = Integer.parseInt(st.nextToken());
			int result = 0;
			for (int row = startRow; row <= endRow; row++) {
				result += board[row][endCol] - board[row][startCol - 1];
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}