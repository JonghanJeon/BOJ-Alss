

import java.awt.font.TextHitInfo;
import java.util.Arrays;
import java.util.Scanner;


public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test=1 ; test<=T; test++) {
			int N = sc.nextInt();
			String[] arr = new String[N];
			int[] arr_num = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.next();
				arr_num[i] = sc.nextInt();
			}
			String result = "";
			int cur_length = 0;
			for(int i=0; i<N; i++) {
				int tmp = cur_length + arr_num[i];
				if(tmp > 10) {
					for(int x=0; x<(10 - cur_length); x++) {
						result += arr[i];
					}
					result += "\n";
					arr_num[i] -= (10 - cur_length);
					i --;
					cur_length=0;
					continue;
				}
				for(int x=0; x<arr_num[i]; x++) {
					result += arr[i];
				}
				cur_length += arr_num[i];
				if(tmp == 10) {
					result += "\n";
					cur_length=0;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append("\n").append(result);
			System.out.println(sb.toString());
		}
	}
}