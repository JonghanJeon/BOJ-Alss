// 임의의 노드에서 가장 긴 경로로 연결돼 있는 노드는 트리의 지름에 해당하는 두 노드 중 하나이다.
import java.util.*;

public class Main {
	
	static int N;
	static ArrayList<Node>[] arrList;
	static int MAX;
	static int NODE;
	static boolean[] visited;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		
		arrList = new ArrayList[N+1];
		MAX = 0;
		visited = new boolean[N+1];
		
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
		dfs(1, 0);
		MAX = 0;
		visited = new boolean[N+1];
		dfs(NODE,0);
		System.out.println(MAX);
	}
	
	public static void dfs(int now, int len) {
		if(len > MAX) {
			MAX = len;
			NODE = now;
		}
		visited[now] = true;
		for(Node node : arrList[now]) {
			if(visited[node.next]) continue;
			dfs(node.next, len+node.w);
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