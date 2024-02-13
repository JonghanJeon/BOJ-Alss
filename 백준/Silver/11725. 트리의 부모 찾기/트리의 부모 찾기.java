import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}

		parent = new int[N + 1];
		visited = new boolean[N + 1];
		Deque<Integer> q = new LinkedList<>();

		q.offer(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int currentNode = q.pollFirst();

			for (int childNode : arr[currentNode]) {
				if (!visited[childNode]) {
					visited[childNode] = true;
					q.offer(childNode);
					parent[childNode] = currentNode;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
}