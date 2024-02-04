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
		boolean isClose = false;
		int answer = 0;
		for (char c : arr) {
			if (c == '(') {
				isClose = false;
				stack.push(c);
			} else {
				if (isClose) { // 연속으로 닫혔을때 = 레이저 기준 오른쪽에 붙어있는 카운팅 안되는 애들
					stack.pop();
					answer++;
				} else {
					stack.pop();
					answer += stack.size();

				}
				isClose = true;
			}
		}
		System.out.println(answer);
	}
}