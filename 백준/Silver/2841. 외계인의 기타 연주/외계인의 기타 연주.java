import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer>[] stacks = new Stack[7];
		for (int i = 1; i < 7; i++) {
			stacks[i] = new Stack<>();
		}
		int P = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());

			while (!stacks[line].isEmpty()) {
				if (stacks[line].peek() > fret) {
					stacks[line].pop();
					cnt++;
				} else {
					break;
				}
			}

			if (!stacks[line].isEmpty() && stacks[line].peek() == fret) {
				continue;
			}

			stacks[line].push(fret);
			cnt++;
		}
		System.out.println(cnt);
	}
}