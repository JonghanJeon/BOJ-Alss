import java.util.Scanner;

import javax.swing.plaf.synth.SynthProgressBarUI;

public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test = 1; test <= 10; test ++) {
			int chance = sc.nextInt();
			int[] arr = new int[100];
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			
			int answer = -1;
			int max = 0;
			int min = 0;
			
			for(int i=0; i<chance; i++) {
				
				int maxIdx = 0;
				int minIdx = 0;
				
				for(int j=1; j<100; j++) {
					if(arr[maxIdx] <= arr[j]) 
						maxIdx = j;
					if(arr[minIdx] >= arr[j]) 
						minIdx = j;
				}
				
				if((arr[maxIdx] - arr[minIdx]) <= 1) {
					answer = arr[maxIdx] - arr[minIdx];
					break;
				}
				
				arr[maxIdx] -= 1;
				arr[minIdx] += 1;

				for(int j=1; j<100; j++) {
					if(arr[maxIdx] <= arr[j]) 
						maxIdx = j;
					if(arr[minIdx] >= arr[j]) 
						minIdx = j;
				}
				
				answer = arr[maxIdx] - arr[minIdx];
				
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
}