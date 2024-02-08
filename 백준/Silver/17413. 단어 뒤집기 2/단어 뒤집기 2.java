import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.imageio.plugins.tiff.TIFFTag;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Stack<Character> voca = new Stack<>();
		boolean isTag = false;
		StringBuilder sb = new StringBuilder();
		for (char c : arr) {
			if (c == '<') {
				while (!voca.isEmpty()) {
					sb.append(voca.pop());
				}
				sb.append("<");
				isTag = true;
				continue;
			}
			if (c == '>') {
				sb.append(">");
				isTag = false;
				continue;
			}
			if (c == ' ') {
				while (!voca.isEmpty()) {
					sb.append(voca.pop());
				}
				sb.append(" ");
				continue;
			}
			if (isTag) { //태그 일때
				sb.append(c);
			} else { //태그가 아닐때
				voca.push(c);
			}
		}

		while (!voca.isEmpty()) {
			sb.append(voca.pop());
		}

		System.out.println(sb);
	}
}