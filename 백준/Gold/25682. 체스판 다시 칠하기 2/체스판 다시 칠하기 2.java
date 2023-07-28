import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] board;
	static int [][] prefix;
	static int [][] blackboard;
	static int [][] whiteboard;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N+1][M+1];
		prefix = new int [N+1][M+1];
		blackboard = new int [N+1][M+1];
		whiteboard = new int [N+1][M+1];
		for(int i=1; i<=N; i++) {
			String [] strs = br.readLine().split("");
			for(int j=1; j<=M; j++) {
				if(strs[j-1].equals("B")) {
					board[i][j]=1;
					prefix[i][j]=1;
				}
				else {
					board[i][j]=0;
					prefix[i][j]=0;
				}
				if((i+j)%2 == 0) {
					blackboard[i][j] = 1;
					whiteboard[i][j] = 0;
				}else {
					blackboard[i][j] = 0;
					whiteboard[i][j] = 1;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(blackboard[i][j] != board[i][j]) blackboard[i][j] = 1;
				else blackboard[i][j] = 0;
				if(whiteboard[i][j] != board[i][j]) whiteboard[i][j] = 1;
				else whiteboard[i][j] = 0;
			}
		}
//		for(int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(blackboard[i]));
//		}
//		System.out.println();
//		for(int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(whiteboard[i]));
//		}
//		System.out.println("================================");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				blackboard[i][j] = blackboard[i][j] + blackboard[i-1][j] + blackboard[i][j-1] - blackboard[i-1][j-1];
				whiteboard[i][j] = whiteboard[i][j] + whiteboard[i-1][j] + whiteboard[i][j-1] - whiteboard[i-1][j-1];
//				int sumB = findsumB(i, j);
//				if(minB > sumB) minB = sumB;
//				int sumW = findsumW(i, j);
//				if(minW > sumW) minW = sumW;
				
			}
		}
//		for(int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(blackboard[i]));
//		}
//		System.out.println();
//		for(int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(whiteboard[i]));
//		}
		int minB = Integer.MAX_VALUE;
		int minW = Integer.MAX_VALUE;		
		for(int i=1; i<=N-K+1; i++) {
			for(int j=1; j<=M-K+1; j++) {
				if(minB > findsumB(i,j)) minB = findsumB(i, j);
				if(minW > findsumW(i,j)) minW = findsumW(i, j);
			}
		}
		System.out.println(Math.min(minW, minB));
		
	}
	public static int findsumB(int row, int col) {
		int result = blackboard[row+K-1][col+K-1] + blackboard[row-1][col-1] - blackboard[row-1][col+K-1] - blackboard[row+K-1][col-1];
		return result;
	}
	public static int findsumW(int row, int col) {
		int result = whiteboard[row+K-1][col+K-1] + whiteboard[row-1][col-1] - whiteboard[row-1][col+K-1] - whiteboard[row+K-1][col-1];
		return result;
	}
}
