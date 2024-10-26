import java.util.*;

class Solution {
    
    class Word {
        String str;
        int count;
        
        Word(String str, int count) {
            this.str = str; this.count = count;
        }
    }
    
    int answer = Integer.MAX_VALUE;
    
    String[] words;
    
    public int solution(String begin, String target, String[] a) {
        
        words = a;
        boolean[] visited = new boolean[words.length];
        dfs(begin, 0, target, visited);
        
        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
        
    }
    
    public void dfs(String cur, int count, String target, boolean[] visited) {
        if (cur.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(cur)) continue;
            if (visited[i]) continue;
            
            int diff = 0;
            for (int j = 0; j < cur.length(); j++) {
                int c1 = cur.charAt(j);
                int c2 = words[i].charAt(j);
                if (c1 != c2) diff++;
            }
            
            if (diff != 1) continue;
            
            visited[i] = true;
            dfs(words[i], count + 1, target, visited);
            visited[i] = false;
        }
    }
}