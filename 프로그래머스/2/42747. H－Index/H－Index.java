import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int amount = citations.length;
        
        //정렬(오름차순)
        Arrays.sort(citations);
        
        //재정렬(내림차순)
        for (int i = 0; i < amount / 2; i++) {
            int tmp = citations[i];
            citations[i] = citations[amount - 1 - i];
            citations[amount - 1 - i] = tmp;
        }
        
        int count = 1;
        
        for (int number : citations) {
            if (count <= number) {
                count++;
            } else {
                break;
            }
        }
        
        return count - 1;
    }
}