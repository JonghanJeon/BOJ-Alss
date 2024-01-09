import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String [][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        for (int i = 0; i < N; i++) {
            String [] arr = br.readLine().split("");
            board[i] = arr;
        }

        int max = 0;

        // 가로로 바꾸기
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N-1; col++) {
                if(!board[row][col].equals(board[row][col+1])){
                    String[][] clone = new String[N][N];
                    for (int i = 0; i < N; i++) {
                        System.arraycopy(board[i], 0, clone[i], 0, N);
                    }
                    String tmp = clone[row][col];
                    clone[row][col] = clone[row][col+1];
                    clone[row][col+1] = tmp;
                    max = Math.max(max, checkMaxValue(clone, N));
                }
            }
        }

        // 세로로 바꾸기
        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N-1; row++) {
                if(!board[row][col].equals(board[row+1][col])){
                    String[][] clone = new String[N][N];
                    for (int i = 0; i < N; i++) {
                        System.arraycopy(board[i], 0, clone[i], 0, N);
                    }
                    String tmp = clone[row][col];
                    clone[row][col] = clone[row+1][col];
                    clone[row+1][col] = tmp;
                    max = Math.max(max, checkMaxValue(clone, N));
                }
            }
        }

        System.out.println(max);
    }

    public static int checkMaxValue(String [][] clone, int N){
        HashMap<String, Integer> map = new HashMap<>();
        int maxCount = 1;
        for (int row = 0; row < N; row++) {
            int currentCount  = 1;
            for (int col = 1; col < N; col++) {
                if(clone[row][col].equals(clone[row][col-1]))
                    currentCount ++;
                else currentCount = 1;

                if(currentCount > maxCount)
                    maxCount = currentCount;
            }
        }

        for (int col = 0; col < N; col++) {
            int currentCount = 1;
            for (int row = 1; row < N; row++) {
                if(clone[row][col].equals(clone[row-1][col]))
                    currentCount ++;
                else currentCount = 1;

                if(currentCount > maxCount)
                    maxCount = currentCount;
            }
        }

        return maxCount;
    }
}