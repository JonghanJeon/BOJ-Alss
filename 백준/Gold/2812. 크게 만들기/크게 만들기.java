import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.imageio.plugins.tiff.TIFFTag;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int digits = N - K;
		char[] arr = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<>();
		for (char c : arr) {
			if (stack.isEmpty()) {
				stack.push(c - '0');
				continue;
			}
			int numeric = c - '0';
			while (K > 0) {
				if (stack.isEmpty())
					break;
				if (numeric <= stack.peek())
					break;
				if (numeric > stack.peek()) {
					stack.pop();
					K--;
				}
			}
			stack.push(numeric);
		}
		StringBuilder sb = new StringBuilder();
		if (stack.size() > digits) {
			for (int i = 0; i < digits; i++) {
				sb.append(stack.get(i));
			}
		} else {
			for (int i : stack) {
				sb.append(i);
			}
		}
		System.out.println(sb);
	}
}