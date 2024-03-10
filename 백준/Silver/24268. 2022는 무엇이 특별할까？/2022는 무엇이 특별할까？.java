import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {

	static int N, d, answer;
	static boolean[] check;
	static int[] array;
	static String number;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		check = new boolean[d];
		number = Integer.toString(N, d);
		array = new int[d];

		dfs(0);

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	static void dfs(int idx) {
		if (idx == d) {
			StringBuilder sb = new StringBuilder();
			for (int i : array) {
				sb.append(i);
			}
			if (Integer.parseInt(number, d) < Integer.parseInt(sb.toString(), d)) {
				if(isPossible()) {
					answer = Math.min(answer, Integer.parseInt(sb.toString(), d));
				}
			}
			return;
		}

		if (idx == 0) {
			for (int i = 1; i < d; i++) {
				if (!check[i]) {
					check[i] = true;
					array[idx] = i;
					dfs(idx + 1);
					check[i] = false;
				}
			}
		} else {
			for (int i = 0; i < d; i++) {
				if (!check[i]) {
					check[i] = true;
					array[idx] = i;
					dfs(idx + 1);
					check[i] = false;
				}
			}
		}
		
	}

	static boolean isPossible() {
		boolean[] tmp = new boolean[d];
		for (int i : array) {
			if (!tmp[i]) {
				tmp[i] = true;
			} else {
				return false;
			}
		}
		return true;
	}
}