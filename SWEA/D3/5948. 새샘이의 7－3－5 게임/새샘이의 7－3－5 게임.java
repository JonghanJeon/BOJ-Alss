import java.util.*;
import java.io.*;

public class Solution {
	
	static class Car {
		int num;
		int weight;
		
		Car(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
	
	static int T;
	static int[] numbers;
	static boolean[] visited;
	static Set<Integer> set;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			answer.append("#").append(no).append(" ");
			numbers = new int[7];
			visited = new boolean[7];
			set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0);

			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			
			answer.append(list.get(4)).append("\n");
		}
		
		System.out.println(answer.toString());
	}
	
	public static void dfs(int depth, int idx, int sum) {
		if (depth == 3) {
			set.add(sum);
			return;
		}
		
		for (int i = idx; i < 7; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(depth + 1, i, sum + numbers[i]);
			visited[i] = false;
		}
	}
}
