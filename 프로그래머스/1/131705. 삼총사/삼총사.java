class Solution {
    
    int[] number;
    int answer = 0;
    
    public int solution(int[] a) {
        
        number = a;
        boolean[] visited = new boolean[number.length];
        dfs(0, visited, 0, 0);
        
        return answer;
    }
    
    public void dfs(int depth, boolean[] visited, int result, int idx) {
        if (depth == 3) {
            if (result == 0) answer++;
            return;
        }
        
        for (int i = idx; i < number.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(depth + 1, visited, result + number[i], i);
            visited[i] = false;
        }
    }
}