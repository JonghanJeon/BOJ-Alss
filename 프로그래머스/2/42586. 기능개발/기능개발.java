import java.util.*;

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        
        Stack<Integer> stk = new Stack<>();
        int max = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            int days = rest / speeds[i];
            if ((rest % speeds[i]) != 0) {
                days += 1;
            }
            
            if (max < days) {
                max = days;
                stk.push(1);
            } else {
                int tmp = stk.pop() + 1;
                stk.push(tmp);
            }
        }
        
        Integer[] answer = stk.toArray(new Integer[stk.size()]);
        
        return answer;
    }
}