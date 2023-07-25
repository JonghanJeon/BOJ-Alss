// 임의의 노드에서 가장 긴 경로로 연결돼 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나이다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<Node>[] arrList;
	static int MAX;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arrList = new ArrayList[N+1];
		
		for(int i=1; i<N+1; i++) {
			arrList[i] = new ArrayList<>();
		}
		for(int i=0; i<N; i++) {
			int now = sc.nextInt();
			while(true) {
				int next = sc.nextInt();
				if(next == -1) break;
                int weight = sc.nextInt();
				arrList[now].add(new Node(next, weight));
			}
		}
		dist = new int[N+1];
		visited = new boolean[N+1];
		bfs(1);
		MAX = 1;
		for(int i=2; i<N+1; i++) {
			if(dist[MAX] < dist[i]) {
				MAX = i;
			}
		}
		dist = new int[N+1];
		visited = new boolean[N+1];
		bfs(MAX);
		Arrays.sort(dist);
		System.out.println(dist[N]);
	}
	
	public static void bfs(int now) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(now);
		visited[now] = true;
		while(!q.isEmpty()) {
			now = q.poll();
			for(Node node : arrList[now]) {
				if(visited[node.next]) continue;
				int n = node.next;
				int w = node.w;
				visited[n] = true;
				q.offer(n);
				dist[n] = dist[now] + w;
			}
		}
	}
}

class Node{
	public int next, w;
	public Node(int next, int w) {
		this.next = next;
		this.w = w;
	}
}
