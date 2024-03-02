import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {

	static int N;
	static long r, c;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());

		int size = (int)Math.pow(2, N);

		int answer = 0;

		int row = 0, col = 0;
		while (row != r || col != c) {
			size = size / 2;

			boolean rowUp = r >= row + size;
			boolean colUp = c >= col + size;

			if (rowUp && colUp) {
				row += size;
				col += size;
				answer += size * size * 3;
			} else if (rowUp && !colUp) {
				row += size;
				answer += size * size * 2;
			} else if (!rowUp && colUp) {
				col += size;
				answer += size * size;
			}
		}

		System.out.println(answer);
	}
}