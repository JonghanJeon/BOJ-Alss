import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int 가로최대 = 0;
        int 세로최대 = 0;
        for (int[] arr : sizes) {
            int 가로, 세로;
            if (arr[0] > arr[1]) {
                가로 = arr[0];
                세로 = arr[1];
            } else {
                가로 = arr[1];
                세로 = arr[0];
            }
            가로최대 = Math.max(가로최대, 가로);
            세로최대 = Math.max(세로최대, 세로);
        }
        return 가로최대 * 세로최대;
    }
}