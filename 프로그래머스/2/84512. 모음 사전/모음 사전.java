import java.util.*;

class Solution {
    
    String[] arr = new String[] {"A", "E", "I", "O", "U"};
    String target;
    int answer = 0;
    boolean flag = false;
    
    public int solution(String word) {
        target = word;
        dfs(0, "");
        return answer;
    }
    
    public void dfs(int depth, String word) {
        if (depth == 6) return;
        if (word.equals(target)) {
            answer++;
            flag = true;
        }
        if (flag) return;
        if (depth != 0) answer++;
        
        for (String str : arr) {
            dfs(depth + 1, word + str);
        }
    }
}