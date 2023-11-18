import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
	static int N;
	static int L;
	static int answer;
	static int[][]  arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test=1; test<=T; test++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			arr = new int[N][2];
			
			for(int i=0; i<N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			answer = 0;
			
			a(0, 0, 0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append(" ").append(answer);
			System.out.println(sb.toString());	
		}
	}
	
	static void a (int start, int sumFlavor, int sumCal) {
		if(sumCal > L) { // 전체 칼로리가 높으면 리턴
			return;
		}
		if(start == N) { // 제일 깊이 들어갔다면, 칼로리 확인해서 바꿔주고 리턴
			if(sumCal <= L) {
				if(sumFlavor > answer) {
					answer = sumFlavor;
				}
			}
			return;
		}
		if(sumCal <= L) { // 칼로리가 적다면 바꿔주기
			if(sumFlavor > answer) {
				answer = sumFlavor;
			}
		}
		a(start+1, sumFlavor, sumCal); // 이번꺼 제꾸고 다음꺼 가는거
		a(start+1, sumFlavor+arr[start][0], sumCal+arr[start][1]); // 이번꺼 포함하고 다음꺼 가는거
		
	}
}