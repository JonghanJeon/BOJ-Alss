import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

import javax.swing.plaf.IconUIResource;

public class Main {

	static int n, m;
	static int[] parent;
	static int[] size;
	static int[] amount;
	static ArrayList<Integer>[] list, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		size = new int[n + 1];
		amount = new int[n + 1];
		// list = new ArrayList[n + 1];
		tree = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			// list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		int root = 1;
		for (int u = 1; u <= n; u++) {
			int v = Integer.parseInt(st.nextToken());

			if (v == -1)
				root = u;
			else {
				tree[v].add(u);
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int currentNode = Integer.parseInt(st.nextToken());
			int volume = Integer.parseInt(st.nextToken());
			amount[currentNode] += volume;
		}

		complimentCalculate(root);

		for (int i = 1; i < amount.length; i++) {
			sb.append(amount[i]).append(" ");
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

	static void complimentCalculate(int currentNode) {
		for (int child : tree[currentNode]) {
			amount[child] += amount[currentNode];
			complimentCalculate(child);
		}
	}
}