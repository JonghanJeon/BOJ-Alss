import java.util.*;

class Solution {
    
    class Pair {
        int x, y;
        char dir;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int x, y;
    int answer = 0;
    
    // 상0 좌1 하2 우3 
    boolean[][][] map = new boolean[11][11][4];
    
    public boolean inMap(int x, int y) {
        return 0 <= x && x <= 10 && 0 <= y && y <= 10;
    }
    
    public void doOrder(int nx, int ny, int dir) {
        // 처음 걸어본 길이면
        if (!map[nx][ny][dir] && !map[x][y][(dir + 2) % 4]) { 
            // 체크하고 거리 1 증가
            map[nx][ny][dir] = true;
            map[x][y][(dir + 2) % 4] = true;
            answer++;
        }
        x = nx; y = ny;
    }
    
    public int solution(String dirs) {
        x = 5; y = 5;
        List<Pair> list = new ArrayList<>();
        int nx, ny;
        for (int i = 0; i < dirs.length(); i++) {
            char order = dirs.charAt(i);
            switch(order) {
                case 'U':
                    nx = x - 1;
                    ny = y;
                    if (inMap(nx, ny)) { // 맵 안일때만 명령 이행
                        doOrder(nx, ny, 0);
                    }
                    break;
                case 'D':
                    nx = x + 1;
                    ny = y;
                    if (inMap(nx, ny)) { // 맵 안일때만 명령 이행
                        doOrder(nx, ny, 2);
                    }
                    break;
                case 'L':
                    nx = x;
                    ny = y - 1;
                    if (inMap(nx, ny)) { // 맵 안일때만 명령 이행
                        doOrder(nx, ny, 1);
                    }
                    break;
                case 'R':
                    nx = x;
                    ny = y + 1;
                    if (inMap(nx, ny)) { // 맵 안일때만 명령 이행
                        doOrder(nx, ny, 3);
                    }
                    break;
            }
        }
        return answer;
    }
}