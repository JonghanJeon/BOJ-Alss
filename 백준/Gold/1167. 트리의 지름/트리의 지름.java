import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

// 임의의 노드에서 가장 긴 경로로 연결돼 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나이다.
public class Main {

	static int V, maxNode, MAX;
	static ArrayList<Node>[] nodes;
	static boolean[] visited;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		nodes = new ArrayList[V + 1];
		StringTokenizer st;
		for (int i = 1; i <= V; i++) {
			nodes[i] = new ArrayList<>();
		}
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int currentNode = Integer.parseInt(st.nextToken());
			while (true) {
				int node = Integer.parseInt(st.nextToken());
				if (node == -1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());
				nodes[currentNode].add(new Node(node, weight));
			}
		}

		visited = new boolean[V + 1];
		distance = new int[V + 1];
		bfs(1);
		MAX = 0;
		for (int i = 1; i <= V; i++) {
			if (distance[MAX] < distance[i]) {
				MAX = i;
			}
		}
		visited = new boolean[V + 1];
		distance = new int[V + 1];
		bfs(MAX);
		Arrays.sort(distance);
		System.out.println(distance[V]);
	}

	static void bfs(final int nowNode) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(nowNode);
		visited[nowNode] = true;
		while (!que.isEmpty()) {
			int n = que.poll();
			for (Node node : nodes[n]) {
				if (visited[node.getNode()]) continue;
				visited[node.getNode()] = true;
				que.offer(node.getNode());
				distance[node.getNode()] = distance[n] + node.getWeight();
			}
		}
	}

}

class Node {
	public int node, weight;

	public Node(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	public int getNode() {
		return node;
	}

	public int getWeight() {
		return weight;
	}
}
