import java.util.*;
import java.io.*;

public class Solution {
	
	static class Pair {
		int v, c;
		
		Pair(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	
	static int T, N, K;
	static Pair[] arr; 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			sb.append("#" + no + " ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new Pair[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[i] = new Pair(v, c);
			}
			
			int[][] dp = new int[N + 1][K + 1];
			
			for (int i = 1; i <= N; i++) {
				Pair item = arr[i];
				for (int w = 1; w <= K; w++) {
					if (item.v > w)
						dp[i][w] = dp[i - 1][w];
					else
						dp[i][w] = Math.max(dp[i - 1][w], item.c + dp[i - 1][w - item.v]);
				}
			}
			
			sb.append(dp[N][K]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
