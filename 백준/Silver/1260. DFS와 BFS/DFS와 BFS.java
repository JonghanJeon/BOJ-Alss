import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int M;
	static int V;
	
	static ArrayList <Integer> [] grap;
	static boolean [] visited;
	
	static Queue<Integer> que = new LinkedList<>();
	
	public static void DFS(int now) {
		visited[now] = true;
		System.out.print(now + " ");
		for(int next : grap[now]) {
			if(!visited[next]) DFS(next);
		}
	}
	
	public static void BFS(int now) {
		que.offer(now);
		visited[now] = true;
		System.out.print(now);
		while(!que.isEmpty()) {
			now = que.poll();
			for(int num : grap[now]) {
				if(!visited[num]) {
					System.out.print(" "+num);
					visited[num] = true;
					que.offer(num);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		String [] strs = io.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		V = Integer.parseInt(strs[2]);
		
		grap = new ArrayList [N+1];
		for(int i=1; i<N+1; i++) grap[i] = new ArrayList <>();
		
		visited = new boolean [N+1];
		
		for(int i=0; i<M; i++) {
			strs = io.readLine().split(" ");
			grap[Integer.parseInt(strs[0])].add(Integer.parseInt(strs[1]));
			grap[Integer.parseInt(strs[1])].add(Integer.parseInt(strs[0]));
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(grap[i]);
		}
		
		DFS(V);
		visited = new boolean [N+1];
		System.out.println();
		BFS(V);
	}
	
}
