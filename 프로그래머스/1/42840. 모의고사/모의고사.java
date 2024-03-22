import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] 수포자1 = {1, 2, 3, 4, 5};
        int[] 수포자2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] 수포자3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[4];
        
        for (int i = 0; i < answers.length; i++) {
            int sol = answers[i];
            if (수포자1[i % 수포자1.length] == sol) {
                cnt[1]++;
            }
            if (수포자2[i % 수포자2.length] == sol) {
                cnt[2]++;
            }
            if (수포자3[i % 수포자3.length] == sol) {
                cnt[3]++;
            }
        }
        
        int maxCnt = 0;
        for (int i = 1; i <= 3; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (cnt[i] == maxCnt) {
                answer.add(i);
            }
        }
        
        return answer;
    }
}