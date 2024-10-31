import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> mainBelt = new Stack<>();
        Stack<Integer> subBelt = new Stack<>();
        
        for (int i = order.length; i >= 1; i--){
            mainBelt.push(i);
        }
        
        for (int number : order) {
            if (!mainBelt.isEmpty() && mainBelt.peek() == number) {
                mainBelt.pop(); answer++;
                continue;
            }
            
            if (!subBelt.isEmpty() && subBelt.peek() == number) {
                subBelt.pop(); answer++;
                continue;
            }
            
            if (!mainBelt.isEmpty() && mainBelt.peek() < number) {
                while (true) {
                    if (mainBelt.peek() == number) {
                        mainBelt.pop(); answer++; break;
                    } else {
                        subBelt.push(mainBelt.pop());
                    }
                }
                continue;
            }
            
            break;
        }
        
        return answer;
    }
}