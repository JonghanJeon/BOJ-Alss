import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		Stack<String> stack = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		for (String str : arr) {
			stack.push(str);
		}

		int cursor = stack.size();

		int M = Integer.parseInt(br.readLine());

		for (int i = 1; i <= M; i++) {
			String[] s = br.readLine().split(" ");
			if (s[0].equals("L")) {
				//커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
				if (!stack.isEmpty())
					stack2.push(stack.pop());

			} else if (s[0].equals("D")) {
				//커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
				if (!stack2.isEmpty())
					stack.push(stack2.pop());

			} else if (s[0].equals("B")) {
				//커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
				// 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
				if (!stack.isEmpty())
					stack.pop();

			} else if (s[0].equals("P")) {
				//$라는 문자를 커서 왼쪽에 추가함
				stack.push(s[1]);

			}
		}

		StringBuilder sb = new StringBuilder();
		for (String str : stack) {
			sb.append(str);
		}
		while (!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		System.out.println(sb);
	}
}