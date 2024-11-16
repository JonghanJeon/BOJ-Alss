import java.util.*;
import java.io.*;

public class Solution {
	
	static class Pair {
		int score; int cal;
		
		Pair(int score, int cal) {
			this.score = score;
			this.cal = cal;
		}
	}
	
	static int T, N, L;
	static Pair[] arr;
	static List<Integer> list = new ArrayList<>();
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			answer.append("#").append(no).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new Pair[N];
			list.clear();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			dfs(0, 0, 0);
			
			Collections.sort(list, Collections.reverseOrder());
			
			answer.append(list.get(0)).append("\n");
		}
		
		System.out.println(answer.toString());
	}
	
	public static void dfs(int scoreSum, int calSum, int idx) {
		list.add(scoreSum);
		
		for (int i = idx; i < N; i++) {
			if (calSum + arr[i].cal <= L) {
				dfs(scoreSum + arr[i].score, calSum + arr[i].cal, i + 1);
			}
		}
	}
}
