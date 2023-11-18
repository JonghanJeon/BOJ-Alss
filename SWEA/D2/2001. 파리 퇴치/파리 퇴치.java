import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test = 1; test <= T; test ++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int [][] arr = new int [N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();  
				}
			}
			int max = 0;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					int sum = 0;
					for(int x=0; x<M; x++) {
						for(int y=0; y<M; y++) {
							sum += arr[i+x][j+y];
						}
					}
					max = Math.max(max, sum);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test).append(" ").append(max);
			System.out.println(sb.toString());
		}
	}
}