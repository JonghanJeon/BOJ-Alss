import java.util.*;

class Solution {
    
    int[] numbers;
    int target;
    int answer = 0;
    
    public int solution(int[] a, int b) {
        numbers = a;
        target = b;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int cur, int sum) {
        
        if (cur == numbers.length) {
            if (sum == target) answer += 1;
            return;
        }
        
        dfs(cur + 1, sum + numbers[cur]);
        dfs(cur + 1, sum - numbers[cur]);
    }
}