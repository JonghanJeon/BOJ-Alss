import java.util.*;

class Solution {
    
    public int answer;
    public int g_target;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        g_target = target;
        dfs(0, numbers, 0);
        return answer;
    }
    
    public void dfs(int depth, int[] numbers, int sum) {
        if (depth == numbers.length) {
            if (sum == g_target) {
                answer++;
            }
            return;
        }
        
        dfs(depth + 1, numbers, sum + numbers[depth]);
        dfs(depth + 1, numbers, sum - numbers[depth]);
    }
}