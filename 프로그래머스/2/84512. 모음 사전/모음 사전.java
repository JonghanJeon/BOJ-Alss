import java.util.*;

class Solution {
    
    String[] arr = new String[] {"A", "E", "I", "O", "U"};
    int answer = 0;
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public void dfs(String cur, int cnt) {
        if (cnt == 6) return;
        list.add(cur);
        for (int i = 0; i < 5; i++) {
            dfs(cur + arr[i], cnt + 1);
        }
        
    }
}