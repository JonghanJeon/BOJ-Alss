import java.util.*;

class Solution {
    
    HashMap<String, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> solution(String msg) {
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString('A' + i), i + 1);
        }
        int idx = 27;
        String w = Character.toString(msg.charAt(0));
        for (int i = 1; i < msg.length(); i++) {
            String c = Character.toString(msg.charAt(i));
            if (map.containsKey(w + c)) {
                w += c;
            } else {
                list.add(map.get(w));
                map.put(w + c, idx++);
                w = c;
            }
        }
        list.add(map.get(w));
        return list;
    }
}