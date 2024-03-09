import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {

	static Stack<Character> stk = new Stack<>();
	static String str, bomb;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		bomb = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			stk.push(str.charAt(i));
			if (stk.size() < bomb.length()) {
				continue;
			}

			if (isSame()) {
				for (int j = 0; j < bomb.length(); j++) {
					stk.pop();
				}
			}
		}

		if (stk.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character c : stk) {
				sb.append(c);
			}
			System.out.println(sb);
		}
	}

	static boolean isSame() {
		int idx = 0;
		for (int i = 0; i < bomb.length(); i++) {
			if (stk.get(stk.size() - bomb.length() + i) != bomb.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}