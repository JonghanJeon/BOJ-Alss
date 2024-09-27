import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Character> deque = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        Deque<Character> ansQue = new LinkedList<>();
        int[] maxArr = priorities.clone();
        Arrays.sort(maxArr);
        for (int i = 0; i < priorities.length; i++) {
            deque.add((char)((int)'A' + i));
            map.put((char)((int)'A' + i), priorities[i]);
        }
        
        
        int idx = maxArr.length - 1;
        System.out.println(maxArr[idx]);
        
        for (int i = idx; i >= 0; i--) {
            while(true) {
                char x = deque.poll();
                int priority = map.get(x);
                if (priority == maxArr[i]) {
                    ansQue.addLast(x);
                    break;
                }
                
                deque.addLast(x);
            }
        }
        
        char tmp = (char)((int)'A' + location);
        int answer = 1;
        while (true) {
            if (ansQue.pollFirst() == tmp) {
                return answer;
            } else {
                answer += 1;
            }
        }
    }
}