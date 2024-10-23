import java.util.*;

class Solution {
    
    public boolean isPrime (Deque<Integer> deq) {
        long t = 1L;
        long number = 0L;
        while(!deq.isEmpty()) {
            number += deq.pollLast() * t;
            t *= 10;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        int number = n;
        Stack<Integer> stk = new Stack<>();
        while(number > 0) {
            int rest = number % k;
            stk.push(rest);
            number /= k;
        }
        
        Deque<Integer> deq = new LinkedList<>();
        while(!stk.isEmpty()) {
            int num = stk.pop();
            if (num != 0) deq.addLast(num);
            else {
                if (deq.isEmpty()) { // 0이 연속으로 나온다? 바로continue
                    continue;
                } else if (deq.size() == 1){ // 0이 나왔고 deque 사이즈가 1이다
                    System.out.println(deq.toString());
                    if (deq.peekFirst() == 1) {
                        deq.clear();
                    } else {
                        // 소수인지 판별
                        if (isPrime(deq)) answer++;
                    }
                } else { // 0이 나왔고 deque 사이즈가 2보다 크다
                    if (isPrime(deq)) answer++;
                }
            }
        }
        
        if (!deq.isEmpty()) {
            if (deq.size() == 1){
                if (deq.peekFirst() != 1) answer++;
            } else {
                if (isPrime(deq)) answer++;
            }
        }
        
        return answer;
    }
}