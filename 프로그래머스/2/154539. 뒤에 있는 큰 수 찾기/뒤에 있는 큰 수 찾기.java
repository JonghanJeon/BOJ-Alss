import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (int i = 1; i < numbers.length; i++) {
            int num = numbers[i];
            while (!stk.isEmpty() && numbers[stk.peek()] < num) {
                answer[stk.pop()] = num;
            }
            
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }
        return answer;
    }
}