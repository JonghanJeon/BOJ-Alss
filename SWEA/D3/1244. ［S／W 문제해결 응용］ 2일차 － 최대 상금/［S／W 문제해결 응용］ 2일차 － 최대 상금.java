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
	
	static int T, K, result;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			sb.append("#" + no + " ");
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			K = Integer.parseInt(st.nextToken());
			arr = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = Integer.parseInt(str.substring(i, i + 1));
			}
			
			result = Integer.MIN_VALUE;
			
			dfs(0, 0);
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dfs(int cnt, int idx) {
		if (cnt == K) {
			int x = 1;
			int num = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				num += arr[i] * x;
				x *= 10;
			}
			result = Math.max(result, num);
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j);
				dfs(cnt + 1, i);
				swap(i, j);
			}
		}
	}
	
	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
