import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int [] arr = new int [number+1];
        
        for(int idx = 1; idx <= number; idx++){
            for(int x=1; x<=Math.sqrt(idx); x++){
                if((idx % x) == 0){
                    if(x != Math.sqrt(idx))
                        arr[idx] ++;
                    arr[idx] ++;
                }
                if(arr[idx] > limit){
                    arr[idx] = power;
                    break;
                }
            }
            answer += arr[idx];
        }
        
        return answer;
    }
}