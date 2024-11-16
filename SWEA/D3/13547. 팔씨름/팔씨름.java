import java.util.*;
import java.io.*;

public class Solution {
	
	static int T;
	static String str;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			answer.append("#").append(no).append(" ");
			str = br.readLine();
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'x') cnt++;
			}
			
			if (cnt < 8) answer.append("YES\n");
			else answer.append("NO\n");
		}
		
		System.out.println(answer.toString());
	}
}
