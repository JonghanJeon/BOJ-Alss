import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

import javax.swing.plaf.IconUIResource;

public class Main {

	static int L, C;
	static char[] arr;
	static Deque<Character> deque;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		deque = new LinkedList<>();
		sb = new StringBuilder();

		Arrays.sort(arr);

		DFS(0, 0);

		System.out.println(sb);
	}

	static void DFS(int depth, int idx) {
		//EXIT
		if (depth == L) {
			if (deque.size() == L && isPossible()) {
				for (int i = 0; i < L; i++) {
					char c = deque.pollFirst();
					sb.append(c);
					deque.offer(c);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = idx; i < C; i++) {
			//TODO
			deque.offer(arr[i]);

			//NEXT
			DFS(depth + 1, i + 1);

			//RECOVERY
			deque.pollLast();
		}
	}

	static boolean isPossible() {
		int cnt = 0;
		if (deque.contains('a')) {
			cnt++;
		}
		if (deque.contains('e')) {
			cnt++;
		}
		if (deque.contains('i')) {
			cnt++;
		}
		if (deque.contains('o')) {
			cnt++;
		}
		if (deque.contains('u')) {
			cnt++;
		}
		if (cnt == 0 || (L - cnt) < 2) {
			return false;
		}
		return true;
	}
}