import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            int 가로 = 0;
            int 세로 = 0;
            if ((yellow % i) == 0) {
                가로 = yellow / i;
                세로 = yellow / 가로;
                int 둘레 = 가로 * 2 + 세로 * 2 + 4;
                if (둘레 == brown) {
                    answer[0] = 가로 + 2;
                    answer[1] = 세로 + 2;
                    break;
                }
            }
        }
        return answer;
    }
}