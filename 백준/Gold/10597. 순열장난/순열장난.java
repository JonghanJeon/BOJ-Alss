import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

import javax.swing.*;

public class Main {

	static char[] arr;
	static int maxNumber;
	static boolean[] visited;
	static Stack<Integer> answer;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		if (arr.length <= 9) {
			//한자리
			maxNumber = arr.length;
		} else { //두자리
			maxNumber = ((arr.length - 9) / 2) + 9;
		}
		visited = new boolean[maxNumber + 1];
		answer = new Stack<>();
		dfs(0);
	}

	static void dfs(int idx) {
		//EXIT
		if (idx == arr.length && answer.size() == maxNumber) {
			StringBuilder sb = new StringBuilder();
			for (int number : answer) {
				sb.append(number + " ");
			}
			System.out.println(sb);
			System.exit(0);
		}

		int number1 = arr[idx] - '0';
		if (number1 == 0) {
			return;
		}

		int number2 = 0;
		if (arr.length - idx > 1) {
			number2 = (number1 * 10) + arr[idx + 1] - '0';
		}

		//TODO
		if (!visited[number1]) {
			visited[number1] = true;
			answer.push(number1);
			dfs(idx + 1);
			answer.pop();
			visited[number1] = false;
		}

		if (number2 == 0 || number2 > maxNumber) {
			return;
		}

		if (!visited[number2]) {
			visited[number2] = true;
			answer.push(number2);
			dfs(idx + 2);
			answer.pop();
			visited[number2] = false;
		}
	}
}