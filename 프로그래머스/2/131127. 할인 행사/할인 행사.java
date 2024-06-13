import java.util.*;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int idx = 0; idx < want.length; idx++) {
                map.put(want[idx], number[idx]);
            }
            for (int j = i; j < i + 10; j++) {
                String saleName = discount[j];
                if (!map.containsKey(saleName)) {
                    break;
                }

                map.put(saleName, map.get(saleName) - 1);
            }

            if (checkZero(map)) {
                answer ++;
            }
        }
        return answer;
    }

    public boolean checkZero(Map<String, Integer> map) {
        for (int number : map.values()) {
            if (number != 0) {
                return false;
            }
        }
        return true;
    }

}