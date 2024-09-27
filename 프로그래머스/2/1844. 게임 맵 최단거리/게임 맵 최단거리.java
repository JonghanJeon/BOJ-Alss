import java.util.*;

class Node {
    int row;
    int col;
    int count;
    
    Node(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}

class Solution {
    
    public int[] dr = {-1, 1, 0, 0}; //row 상 하 좌 우
    public int[] dc = {0, 0, -1, 1}; //col 상 하 좌 우
    
    public int solution(int[][] maps) {
        int answer = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            
            if (cur.row == maps.length - 1 &&
                cur.col == maps[0].length - 1) {
                answer = cur.count;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int newRow = cur.row + dr[i];
                int newCol = cur.col + dc[i];
                
                if (0 <= newRow && newRow < maps.length &&
                    0 <= newCol && newCol < maps[0].length) {
                    
                    if (maps[newRow][newCol] == 1 &&
                        !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        Node nextNode = new Node(newRow, newCol, cur.count + 1);
                        que.offer(nextNode);
                    }
                }
            }
            
        }
        
        return answer;
    }
}