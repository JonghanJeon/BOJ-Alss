import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.charAt(0) == '.')
				break;

			Stack<Character> stk = new Stack<>();

			boolean isError = false;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					stk.push(')');
				} else if (c == '[') {
					stk.push(']');
				} else if (c == ')' || c == ']') {
					if (stk.isEmpty()) {
						isError = true;
						break;
					} else {
						if (stk.pop() != c) {
							isError = true;
							break;
						}
					}
				}
			}
			if (!stk.isEmpty()) {
				sb.append("no").append("\n");
			} else {
				if (isError)
					sb.append("no").append("\n");
				else
					sb.append("yes").append("\n");
			}
		}
		System.out.println(sb);
	}
}