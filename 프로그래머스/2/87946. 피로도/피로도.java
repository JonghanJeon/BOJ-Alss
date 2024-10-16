class Solution {
    
    public int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(0, dungeons, 0, visited, k);
        
        return answer;
    }
    
    void dfs(int depth, int[][] dungeons, int cnt, boolean[] visited, int k) {
        if (depth == dungeons.length) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            int needStamina = dungeons[i][0];
            int useStamina = dungeons[i][1];
            if (needStamina <= k) {
                visited[i] = true;
                dfs(depth + 1, dungeons, cnt + 1, visited, k - useStamina);
                visited[i] = false;
            } else {
                visited[i] = true;
                dfs(depth + 1, dungeons, cnt, visited, k);
                visited[i] = false;
            }
        }
    }
    
}