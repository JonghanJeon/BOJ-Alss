import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) throws Exception {
        Stack<Integer> stk = new Stack<>();
        for (String command : cmd) {
            char c = command.charAt(0);
            if (c == 'U') {
                k -= Integer.parseInt(command.substring(2));
            } else if (c == 'D') {
                k += Integer.parseInt(command.substring(2));
            } else if (c == 'C') {
                stk.push(k);
                n--;
                if (k == n) {
                    k--;
                }
            } else {
                if (stk.pop() <= k) {
                    k++;
                }
                n++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }
        while(!stk.isEmpty()) {
            sb.insert(stk.pop(), "X");
        }

        return sb.toString();
    }
}