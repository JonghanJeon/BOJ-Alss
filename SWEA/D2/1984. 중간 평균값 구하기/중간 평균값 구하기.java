

import java.util.Arrays;
import java.util.Scanner;


public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test=1; test<=T ; test++) {
			int[] arr = new int [10];
			int max = -1;
			int min = 10001;
			for(int i=0; i<10; i++) {				
				int tmp = sc.nextInt();
				if(max < tmp)
					max = tmp;
				if(min > tmp)
					min = tmp;
				arr[i] = tmp;
			}
			
			int sum = 0;
			
			for(int num : arr) {
				if(num == max)
					continue;
				if(num == min)
					continue;
				sum += num;
			}
			
			Double avg = sum / 8.0;
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append(" ").append(String.format("%.0f", avg));
			System.out.println(sb.toString());
			
		}
	}
}