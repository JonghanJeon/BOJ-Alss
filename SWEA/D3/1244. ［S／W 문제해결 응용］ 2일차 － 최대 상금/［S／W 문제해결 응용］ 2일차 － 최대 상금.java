import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Solution
{
	
	static int chance;
	static int answer;
	static String [] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case ++) {
			arr = sc.next().split("");
			chance = sc.nextInt();
			
			if(arr.length < chance) {
				chance = arr.length;
			}
			
			answer = 0;
			dfs(0, 0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
	
	static void dfs(int start, int cnt) {
		
		if(cnt == chance) {
			String str = "";
			for(String s: arr) {
				str += s;
			}
			answer = Math.max(Integer.parseInt(str), answer);
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				String tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				
				dfs(i, cnt+1);
				
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
	}
}