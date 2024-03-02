import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] board;
	static int count;
	
	public static void queen(int col) {
		if(col == N) {
			count ++;
			return;
		}
		for(int row=0; row<N; row++) {
			board[col] = row;
			if(check(col)) queen(col+1);
		}
	}
	
	public static boolean check(int col) {
		
		for(int COL=0; COL<col; COL++) {
			if(board[col] == board[COL] || Math.abs(col-COL) == Math.abs(board[col] - board[COL])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		board = new int[N];
		for(int i=0; i<N; i++) board[i] = -1;
		
		count = 0;
		for(int i=0; i<N; i++) {
			board[0] = i;
			queen(1);
		}
		System.out.println(count);
	}
	
}
