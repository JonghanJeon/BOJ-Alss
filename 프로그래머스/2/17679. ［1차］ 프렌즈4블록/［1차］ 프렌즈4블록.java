import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[board.length][board[0].length()];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        List<int[]> list = new ArrayList<>();
        while (true) {
            // 좌표 찾아서 리스트에 추가
            for (int x = 0; x < map.length - 1; x++) {
                for (int y = 0; y < map[0].length - 1; y++) {
                    if (map[x][y] == ' ') continue;
                    
                    if (map[x][y] == map[x + 1][y] && map[x][y] == map[x][y + 1] && map[x][y] == map[x + 1][y + 1]) {
                        list.add(new int[] {x, y});
                    }
                }
            }
           
            // 해당 좌표가 없다면
            // 즉, list.size() == 0 이라면 break;
            if (list.size() == 0) break;
            
            // 해당 좌표가 있다면
            // 해당 좌표 자리 모두 빈칸으로 교체
            for (int[] pair : list) {
                int x = pair[0]; int y = pair[1];
                map[x][y] = ' ';
                map[x + 1][y] = ' ';
                map[x][y + 1] = ' ';
                map[x + 1][y + 1] = ' ';
            }
            
            // 좌표 다 밑으로 당기기
            for (int j = 0; j < map[0].length; j++) {
                Queue<Character> que = new LinkedList<>();
                for (int i = map.length - 1; i >= 0; i--) {
                    if (map[i][j] != ' ') {
                        que.add(map[i][j]);
                        map[i][j] = ' ';
                    }
                }
                
                int idx = map.length - 1;
                while (!que.isEmpty()) {
                    map[idx--][j] = que.poll();
                }
            }
            list.clear();
        }
        
        int answer = 0;
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y] == ' ') answer++;
            }
        }
        
        return answer;
    }
}