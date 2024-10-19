import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> base = new HashMap<>();
        for (int num : topping) {
            if (!base.containsKey(num))
                base.put(num, 1);
            else base.put(num, base.get(num) + 1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            if (base.get(topping[i]) == 1) {
                base.remove(topping[i]);
            } else {
                base.put(topping[i], base.get(topping[i]) - 1);
            }
            Set<Integer> keys = base.keySet();
            if (set.size() == keys.size())
                answer++;
            
        }
        return answer;
    }
}