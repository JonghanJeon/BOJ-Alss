import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int index = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            List<Integer> list = new ArrayList<>();
            for (int idx = i - 1; idx < j; idx++) {
                list.add(array[idx]);
            }
            
            Collections.sort(list);
            answer[index++] = list.get(k - 1); 
        }
        
        return answer;
    }
}