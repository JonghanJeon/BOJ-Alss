import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y + 1];
        Queue<int[]> que = new LinkedList<>();
        visited[x] = true;
        que.add(new int[] {x, 0});
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            
            if (cur[0] == y) {
                return cur[1];
            }
            
            if (cur[0]* 3 <= y && !visited[cur[0]* 3]) {
                que.add(new int[] {cur[0] * 3, cur[1] + 1});
                visited[cur[0] * 3] = true;
            }
            if (cur[0] * 2 <= y && !visited[cur[0] * 2]) {
                que.add(new int[] {cur[0] * 2, cur[1] + 1});
                visited[cur[0] * 2] = true;
            }
            if (cur[0] + n <= y && !visited[cur[0] + n]) {
                que.add(new int[] {cur[0] + n, cur[1] + 1});
                visited[cur[0] + n] = true;
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}