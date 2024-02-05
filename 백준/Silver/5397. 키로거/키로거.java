import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			char[] arr = br.readLine().toCharArray();
			Stack<Character> firstStack = new Stack<>();
			Stack<Character> secondStack = new Stack<>();
			for (char c : arr) {
				if (c == '<' || c == '>') {
					//화살표
					if (c == '<' && !firstStack.isEmpty()) {
						secondStack.push(firstStack.pop());
					} else if (c == '>' && !secondStack.isEmpty()){
						firstStack.push(secondStack.pop());
					}
				} else if (c == '-') {
					//백스페이스
					if (!firstStack.isEmpty()) {
						firstStack.pop();
					}
				} else {
					//문자
					firstStack.push(c);
				}
			}
			StringBuilder sb = new StringBuilder();
			for (char c : firstStack)
				sb.append(c);
			Collections.reverse(secondStack);
			for (char c : secondStack)
				sb.append(c);

			System.out.println(sb);
		}
	}
}