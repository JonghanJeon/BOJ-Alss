import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, boolean[] visited, int cur) {
        visited[cur] = true;
        
        for (int i = 0; i < computers[cur].length; i++) {
            // 자기자신은 continue;
            if (i == cur) continue;
            // 연결되어 있고, 방문하지 않았다면 방문해야지
            if (computers[cur][i] == 1 && visited[i] == false) {
                dfs(computers, visited, i);
            }
        }
    }
}