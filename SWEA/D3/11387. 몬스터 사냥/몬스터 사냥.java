import java.util.*;
import java.io.*;

public class Solution {
	
	static int T, D, L, N;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			answer.append("#").append(no).append(" ");
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			double per = L / 100.0;
			double total = 0;
			for (int n = 0; n < N; n++) {
				double damage = D * (1 + n * per);
				total += damage;
			}
			answer.append((int) total).append("\n");
		}
		
		System.out.println(answer.toString());
	}
}
