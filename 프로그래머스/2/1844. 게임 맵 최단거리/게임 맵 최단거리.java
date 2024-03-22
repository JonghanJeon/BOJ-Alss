import java.util.*;

class Solution {
    
    public int[][] board;
    public boolean[][] visited;
    public int answer = -1;
    public int[] dr = {-1, 1, 0, 0}; //상하
    public int[] dc = {0, 0, -1, 1}; //좌우
    
    public int solution(int[][] maps) {
        board = maps;
        visited = new boolean[maps.length][maps[0].length];
        // dfs(0, 0, 1);
        // if (answer == Integer.MAX_VALUE) {
        //     return -1;
        // } else {
        //     return answer;
        // }
        bfs(0, 0);
        return answer;
        
    }
    
    public void bfs(int row, int col) {
        Queue<Node> que = new LinkedList<>();
        
        que.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!que.isEmpty()) {
            Node cur = que.poll();
            
            if (cur.row == board.length - 1 && cur.col == board[0].length - 1) {
                answer = cur.count;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int newRow = cur.row + dr[i];
                int newCol = cur.col + dc[i];
                if (0 <= newRow && newRow < board.length && 0 <= newCol && newCol < board[0].length) {
                    if (visited[newRow][newCol] == false && board[newRow][newCol] == 1) {
                        visited[newRow][newCol] = true;
                        que.offer(new Node(newRow, newCol, cur.count + 1));
                    }
                }
            }
        }
    }
    
    public class Node {
        int row;
        int col;
        int count;
        
        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    
//     public void dfs(int row, int col, int sum) {
//         if (answer <= sum) {
//             return;
//         }
        
//         if (row == board.length - 1 && col == board[0].length - 1) {
//             answer = Math.min(answer, sum);
//             return;
//         }
        
//         board[row][col] = 0;
        
//         //우하좌상
//         int[] dr = {0, 1, 0, -1}; 
//         int[] dc = {1, 0, -1, 0}; 
//         for (int i = 0; i < 4; i++) {
//             int newRow = row + dr[i];
//             int newCol = col + dc[i];
//             if (0 <= newRow && newRow < board.length && 0 <= newCol && newCol < board[0].length) {
//                if (board[newRow][newCol] == 1) {
//                    dfs(newRow, newCol, sum + 1);
//                } 
//             }
//         }
        
        
//         board[row][col] = 1;
//     }
}