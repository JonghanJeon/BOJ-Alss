import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[] numbers;
	static int[] operators;
	static long answerMax;
	static long answerMin;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operators = new int[4];
		answerMax = Long.MIN_VALUE;
		answerMin = Long.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		DFS(0, numbers[0]);

		System.out.println(answerMax);
		System.out.println(answerMin);
	}

	static void DFS(int depth, long midResult) {
		if (depth == N - 1) {
			answerMax = Math.max(midResult, answerMax);
			answerMin = Math.min(midResult, answerMin);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				//TODO
				operators[i]--;
				DFS(depth + 1, calculate(midResult, numbers[depth + 1], i));
				
				//RECOVERY
				operators[i]++;
			}
		}
	}
	
	static long calculate(long num1, long num2, int operator) {
		if (operator == 0) {
			return num1 + num2;
		} else if (operator == 1) {
			return num1 - num2;
		} else if (operator == 2) {
			return (long)num1 * num2;
		} else {
			return num1 / num2;
		}
	}
}