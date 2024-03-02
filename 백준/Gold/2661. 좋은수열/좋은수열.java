import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

import javax.swing.*;

public class Main {

	static int N;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		answer[0] = 1;
		dfs(1);
	}

	static void dfs(int idx) {
		if (idx == N) {
			StringBuilder sb = new StringBuilder();
			for (int number : answer) {
				sb.append(number);
			}
			System.out.println(sb);
			System.exit(0);
		}

		for (int i = 1 ; i <= 3 ; i ++) {
			if (answer[idx - 1] == i) {
				continue;
			}
			answer[idx] = i;
			if (isPossible(idx)) {
				dfs(idx + 1);
			}
		}
	}

	static boolean isPossible(int idx) {
		boolean flag = true;
		int cnt = 1;
		while (true) {
			if ((cnt * 2) > (idx + 1)) {
				break;
			}
			StringBuilder number1 = new StringBuilder();
			StringBuilder number2 = new StringBuilder();
			for (int i = idx - cnt + 1; i <= idx; i++) {
				number1.append(answer[i]);
				number2.append(answer[i - cnt]);
			}

			if (number1.toString().contentEquals(number2)) {
				flag = false;
				break;
			}

			cnt++;
		}

		return flag;
	}
}