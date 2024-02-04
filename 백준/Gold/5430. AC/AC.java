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

			char[] orderArr = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] strArr = str.substring(1, str.length() - 1).split(",");
			Deque<String> deque = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				deque.offer(strArr[i]);
			}

			boolean isNotEmpty = true;
			boolean isForward = true;
			for (char order : orderArr) {
				if (order == 'R') { // 뒤집기
					isForward = !isForward;
				} else { //D 맨앞에꺼 빼기
					if (isForward) {
						if (deque.isEmpty()) {
							isNotEmpty = false;
							sb.append("error").append("\n");
							break;
						} else {
							deque.pollFirst();
						}
					} else {
						if (deque.isEmpty()) {
							isNotEmpty = false;
							sb.append("error").append("\n");
							break;
						} else {
							deque.pollLast();
						}
					}

				}
			}

			if (isNotEmpty) {
				if (isForward) {
					String answer = "[" + String.join(",", deque) + "]";
					sb.append(answer).append("\n");
				} else {
					Collections.reverse((List<?>)deque);
					String answer = "[" + String.join(",", deque) + "]";
					sb.append(answer).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}