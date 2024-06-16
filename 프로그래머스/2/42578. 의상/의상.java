import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] row : clothes) {
            if (!map.containsKey(row[0])) {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(row[1]);
                map.put(row[0], arr);
                continue;
            }
            map.get(row[0]).add(row[1]);
        }
    
        int answer = 0;
        return answer;
    }
}