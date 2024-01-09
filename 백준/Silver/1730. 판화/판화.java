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
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                board[row][col] = ".";
            }
        }

        int rowPointer = 0;
        int colPointer = 0;

        String [] arr = br.readLine().split("");

        for(String str : arr){
            if(str.equals("U") && rowPointer > 0){
                doRow(rowPointer, colPointer);
                rowPointer --;
                doRow(rowPointer, colPointer);
            } else if (str.equals("D") && rowPointer < (N-1)){
                doRow(rowPointer, colPointer);
                rowPointer ++;
                doRow(rowPointer, colPointer);
            } else if (str.equals("L") && colPointer  > 0){
                doCol(rowPointer, colPointer);
                colPointer --;
                doCol(rowPointer, colPointer);
            } else if (str.equals("R") && colPointer < (N-1)){
                doCol(rowPointer, colPointer);
                colPointer ++;
                doCol(rowPointer, colPointer);
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.printf("%s",board[row][col]);
            }
            System.out.println();
        }
    }
    
    public static void doRow(int rowPointer, int colPointer){
        if(board[rowPointer][colPointer].equals("-") || board[rowPointer][colPointer].equals("+"))
            board[rowPointer][colPointer] = "+";
        else board[rowPointer][colPointer] = "|";
    }
    
    public static void doCol(int rowPointer, int colPointer){
        if(board[rowPointer][colPointer].equals("|") || board[rowPointer][colPointer].equals("+"))
            board[rowPointer][colPointer] = "+";
        else board[rowPointer][colPointer] = "-";
    }
}