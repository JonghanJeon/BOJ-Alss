import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int sco : scoville) {
            que.offer(sco);
        }
        
        while (que.size() >= 2) {
            int lowSco = que.poll();
            if (K <= lowSco) {
                break;
            }
            int lowSco2 = que.poll();
            int newSco = lowSco + (lowSco2 * 2);
            que.offer(newSco);
            answer++;
        }
        
        if (que.peek() < K) {
            return -1;
        } else {
            return answer;
        }
        
    }
}