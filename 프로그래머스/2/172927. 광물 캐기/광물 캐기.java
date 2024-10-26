import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        dfs(picks, minerals, 0, 0);
        return answer;
    }
    
    public void dfs(int[] picks, String[] minerals, int cur, int stamina) {
        boolean allPickUsed = true;
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] != 0) {
                allPickUsed = false;
                break;
            }
        }
        
        if (allPickUsed || cur == minerals.length) {
            answer = Math.min(answer, stamina);
            return;
        }
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] == 0)
                continue;
            
            picks[i] -= 1;
            int nStamina = stamina;
            int fin = cur + 5 > minerals.length ? minerals.length : cur + 5;
            
            for (int idx = cur; idx < fin; idx++) {
                String mineral = minerals[idx];
                if (i == 0) { //다이아 곡괭이
                    nStamina += 1;
                } else if (i == 1) { //철 곡괭이
                    if (mineral.equals("diamond")) nStamina += 5;
                    else nStamina += 1;
                } else { //돌 곡괭이
                    if (mineral.equals("diamond")) nStamina += 25;
                    else if (mineral.equals("iron")) nStamina += 5;
                    else nStamina += 1;
                }
            }
            
            dfs(picks, minerals, fin, nStamina);
            picks[i] += 1;
        }
        
    }
}