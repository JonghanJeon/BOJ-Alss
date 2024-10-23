import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer.append(" ");
                idx = 0;
            }
            else {
                if (idx % 2 == 0) { //짝수일 경우
                    answer.append(String.valueOf(c).toUpperCase());
                    idx++;
                } else { //홀수인 경우
                    answer.append(String.valueOf(c).toLowerCase());
                    idx++;
                }
            }
        }
        return answer.toString();
    }
}