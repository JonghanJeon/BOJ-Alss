import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		boolean isImpossible = false;
		for (char c : arr) {
			if (c == 'P') {
				if (!stack.isEmpty() && stack.peek() == 'A') {
					for (int i = 0; i < 2; i++) {
						stack.pop();
					}
					continue;
				}
				stack.push(c);
			} else { //A
				if (stack.size() >= 2) {
					stack.push(c);
				} else {
					isImpossible = true;
					break;
				}
			}
		}

		if (stack.size() != 1 || stack.peek() == 'A')
			isImpossible = true;

		if (isImpossible)
			System.out.println("NP");
		else
			System.out.println("PPAP");
	}
}