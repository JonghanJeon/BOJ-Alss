import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stk = new Stack<>();
            boolean isCorrect = true;
            for (int j = i; j < s.length() + i; j++) {
                char c = s.charAt(j % s.length());
                // 여는 괄호일 경우
                if (c == '[' || c == '{' || c == '(') {
                    
                    stk.push(c);
                    
                } else { // 닫는 괄호일 경우
                    
                    if (stk.isEmpty()) {
                        isCorrect = false;
                        break;
                    }
                
                    char peek = stk.peek();
                    if (map.get(peek) != c) {
                        isCorrect = false;
                        break;
                    } else {
                        stk.pop();
                    }
                    
                }
                
            }
            
            if(stk.isEmpty() && isCorrect) {
                answer++;
            }
            
        }
        return answer;
    }
}