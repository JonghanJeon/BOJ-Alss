import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int amount = citations.length;
        
        //정렬
        Arrays.sort(citations);
        
        int[] arr = new int[amount];
        
        int idx = amount - 1;
        for (int i = 0; i < amount; i++) {
            arr[i] = citations[idx--];
        }
        
        int count = 1;
        
        for (int number : arr) {
            if (count <= number) {
                count++;
            } else {
                break;
            }
        }
        
        return count - 1;
    }
}