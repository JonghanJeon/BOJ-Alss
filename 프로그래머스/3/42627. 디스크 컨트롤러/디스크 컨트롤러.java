import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        
        PriorityQueue<int[]> workQue = new PriorityQueue<>(
            (o1, o2) -> {
                return o1[1] - o2[1];
            }
        );
            
        PriorityQueue<int[]> inQue = new PriorityQueue<>(
            (o1, o2) -> {
                return o1[0] - o2[0];
            }
        );  
        
        for (int[] job : jobs) {
            inQue.offer(job);
        }
        
        while (true) {
            
            if (inQue.isEmpty() && workQue.isEmpty()) {
                break;
            }
            
            while(!inQue.isEmpty() && inQue.peek()[0] <= time) {
                workQue.offer(inQue.poll());
            }
            
            if (workQue.isEmpty()) {
                time = inQue.peek()[0];
            } else {
                int[] job = workQue.poll();
                time += job[1];
                answer += time - job[0];
            }
        }
        
        return answer/jobs.length;
    }
}