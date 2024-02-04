import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < T; testCase++) {

			char[] arr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean isError = false;
			for (char c : arr) {
				if (c == '(') {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						isError = true;
						break;
					}
					stack.pop();
				}
			}

			if (isError || !stack.isEmpty()) {
				sb.append("NO").append("\n");
			} else
				sb.append("YES").append("\n");
		}
		System.out.println(sb);
	}
}