import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] board;
	public static int[][] prefixSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		board = new int[N + 1][M + 1];
		prefixSum = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= str.length(); j++) {
				board[i][j] = Character.getNumericValue(str.charAt(j - 1));
				prefixSum[i][j] = board[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
			}
		}

		int answer = 0;
		for (int startRow = 1; startRow <= N; startRow++) {
			for (int startCol = 1; startCol <= M; startCol++) {
				if (board[startRow][startCol] == 1) {
					int tmp = 0;
					while (true) {
						int defRow = startRow + tmp;
						int defCol = startCol + tmp;
						if (N < defRow || M < defCol)
							break;
						int result = isPossible(startRow, startCol, defRow, defCol);
						if (result == -1)
							break;
						else
							answer = Math.max(answer, result);
						tmp++;
					}
				}
			}
		}

		System.out.println(answer);
	}

	public static int isPossible(int startRow, int startCol, int defRow, int defCol) {
		int size = (defRow - startRow + 1) * (defCol - startCol + 1);
		int checkSize =
			prefixSum[defRow][defCol] - prefixSum[defRow][startCol - 1] - prefixSum[startRow - 1][defCol] + prefixSum[
				startRow - 1][startCol - 1];
		if (size == checkSize)
			return size;
		else
			return -1;
	}
}