import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N, M;
	static boolean result;
	static ArrayList<Integer>[] arrList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		arrList = new ArrayList [N];
		for(int i=0; i<N; i++) {
			arrList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			arrList[a].add(b);
			arrList[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(0, i);
			if(result == true) {
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.println(0);
	}
	
	public static void dfs(int depth, int now) {
		if(depth == 4) {
			result = true;
			return;
		}
		for(int next : arrList[now]) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(depth+1, next);
			visited[next] = false;
		}
	}
}