import java.util.*;

class Solution {
    public int solution(String skillTree, String[] skill_trees) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        for (String skill : skill_trees) {
            // 초기화
            q.clear();
            for (int i = 0; i < skillTree.length(); i++) {
                q.add(skillTree.charAt(i));
            }
            boolean isPossible = true;
            for (int i = 0; i < skill.length(); i++) {
                char c = skill.charAt(i);
                if (!q.contains(c)) continue;
                
                if (q.peek() == c) q.poll();
                else {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) answer++;
            
            
        }
        return answer;
    }
}