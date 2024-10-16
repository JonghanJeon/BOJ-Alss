import java.util.*;

class Solution {
    public List<String> list = new ArrayList<>();
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        for (String city : cities) {
            
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }
            
            if (list.size() == 0) {
                answer += 5;
                list.add(city);
                continue;
            } else if (list.size() < cacheSize) {
                
                int result = isHit(city);
                if (result >= 0) { // 적중시
                    list.remove(result);
                    list.add(city);
                    answer++;
                } else { // 비적중시
                    answer += 5;
                    list.add(city);
                }
                
            } else if (list.size() == cacheSize) {
                
                int result = isHit(city);
                if (result >= 0) { // 적중시
                    list.remove(result);
                    list.add(city);
                    answer++;
                } else { // 비적중시
                    list.remove(0);
                    list.add(city);
                    answer += 5;
                }
            }
        }
        return answer;
    }
    
    int isHit(String city) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(city)) {
                return i;
            }
        }
        return -1;
    }
}