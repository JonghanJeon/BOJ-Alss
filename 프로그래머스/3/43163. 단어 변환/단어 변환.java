import java.util.*;

class Word {
    String word;
    int count;
    
    Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Word> que = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        que.offer(new Word(begin, 0));
        
        
        while(!que.isEmpty()) {
            Word cur = que.poll();
            
            if (cur.word.equals(target)) {
                answer = cur.count;
                break;
            }
            
            for (int i = 0; i <words.length; i++) {
                int cnt = 0;
                String word = words[i];
                for (int j = 0; j < cur.word.length(); j++) {
                    if (cur.word.charAt(j) != word.charAt(j)) cnt++;
                }
                
                if (cnt == 1 && !visited[i]) {
                    visited[i] = true;
                    que.offer(new Word(word, cur.count + 1));
                }
            }
        }
        
        return answer;
    }
}