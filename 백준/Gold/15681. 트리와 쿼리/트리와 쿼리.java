import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

import javax.swing.plaf.IconUIResource;

public class Main {

	static int N, R, Q;
	static int[] parent;
	static int[] size;
	static ArrayList<Integer>[] list, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		size = new int[N + 1];
		list = new ArrayList[N + 1];
		tree = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		}

		makeTree(R, -1);
		countSubtreeNodes(R);

		for (int i = 0; i < Q; i++) {
			int target = Integer.parseInt(br.readLine());
			sb.append(size[target]).append("\n");
		}

		System.out.println(sb);
	}

	static void makeTree(int currentNode, int parentNode) {

		for (int node : list[currentNode]) {
			if (node != parentNode) {
				tree[currentNode].add(node);
				parent[node] = currentNode;
				makeTree(node, currentNode);
			}
		}
	}

	static void countSubtreeNodes(int currentNode) {
		size[currentNode] = 1;
		for (int child : tree[currentNode]) {
			countSubtreeNodes(child);
			size[currentNode] += size[child];
		}
	}
}