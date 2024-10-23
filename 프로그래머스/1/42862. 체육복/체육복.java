import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1);
        
        for (int idx : reserve) {
            clothes[idx]++;
        }
        
        for (int idx : lost) {
            clothes[idx]--;
        }
        
        Arrays.sort(reserve);
        
        int[] dir = new int[] {-1, 1};
        for (int idx : reserve) {
            if (clothes[idx] > 1) {
                for (int d = 0; d < 2; d++) {
                    int nIdx = idx + dir[d];
                    
                    if (!(1 <= nIdx && nIdx <= n)) continue;
                    
                    if (clothes[nIdx] == 0) {
                        clothes[nIdx]++;
                        clothes[idx]--;
                        break;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) answer++;
        }
        return answer;
    }
}