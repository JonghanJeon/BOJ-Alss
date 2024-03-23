import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int t = 0; t < commands.length; t++) {
            int[] arr = commands[t];
            int start = arr[0] - 1;
            int end = arr[1] - 1;
            int target = arr[2] - 1;
            int[] tmp = new int[end - start + 1];
            int idx = 0;
            for (int k = start; k <= end; k++) {
                tmp[idx] = array[k];
                idx++;
            }
            Arrays.sort(tmp);
            answer[t] = tmp[target];
        }
        return answer;
    }
}