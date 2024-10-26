class Solution {
    
    int[] info;
    int[][] edges;
    int answer = 0;
    
    public int solution(int[] a, int[][] b) {
        
        info = a; edges = b;
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        dfs(visited, 1, 0);
        
        return answer;
    }
    
    public void dfs(boolean[] visited, int sheep, int wolf) {
        answer = Math.max(answer, sheep);
        if (sheep <= wolf) return;
        
        for (int[] node : edges) {
            if (visited[node[0]] && !visited[node[1]]) {
                visited[node[1]] = true;
                if (info[node[1]] == 0) dfs(visited, sheep + 1, wolf);
                else dfs(visited, sheep, wolf + 1);
                visited[node[1]] = false;
            }
        }
    }
}