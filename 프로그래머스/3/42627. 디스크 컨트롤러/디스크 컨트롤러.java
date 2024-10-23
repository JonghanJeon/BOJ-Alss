import java.util.*;

class Solution {
    
    class Job {
        int in;
        int process;
        
        Job(int in, int process) {
            this.in = in;
            this.process = process;
        }
    }
    
    PriorityQueue<Job> jobQue = new PriorityQueue<>((o1, o2) -> {
        return o1.in - o2.in;
    });
    
    PriorityQueue<Job> workQue = new PriorityQueue<>((o1, o2) -> {
        return o1.process - o2.process;
    });
    
    public int solution(int[][] jobs) {
        int answer = 0;
        for (int[] row : jobs) {
            Job job = new Job(row[0], row[1]);
            jobQue.add(job);
        }
        
        int time = 0;
        while(!(jobQue.isEmpty() && workQue.isEmpty())) {
            while(!jobQue.isEmpty()) {
                Job cur = jobQue.poll();
                if (cur.in <= time) workQue.add(cur);
                else {
                    jobQue.add(cur);
                    break;
                }
            }
            
            if (!workQue.isEmpty()) {
                Job cur = workQue.poll();
                time += cur.process;
                answer += (time - cur.in);
            } else { // 작업 큐가 비었을 때는 시간을 다음 작업까지 당겨주어야 한다.그러지 않으면 무한루프가 돼버린다.
                time = jobQue.peek().in;
            }
        }
        
        return answer/jobs.length;
    }
}