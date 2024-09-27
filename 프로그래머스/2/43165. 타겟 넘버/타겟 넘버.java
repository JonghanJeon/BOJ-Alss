import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, numbers, 0, target);
        return answer;
    }
    
    public void dfs(int depth, int[] numbers, int result, int target){
        if (depth == numbers.length) {
            if (result == target) {
                answer += 1;
            }
            return ;
        }
        
        dfs(depth + 1, numbers, result + numbers[depth], target);
        dfs(depth + 1, numbers, result - numbers[depth], target);
        
    }
}