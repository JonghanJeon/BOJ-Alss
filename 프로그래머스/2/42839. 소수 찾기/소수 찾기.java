import java.util.*;

class Solution {
    
    public boolean isPrime(int n) {
        if (n == 1 || n == 0) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    String[] numbers;
    Set<Integer> set = new HashSet<>();
    int answer = 0;
    
    public int solution(String a) {
        
        numbers = new String[a.length()];
        for (int i = 0; i < a.length(); i++) {
            numbers[i] = a.substring(i, i + 1);
        }
        boolean[] visited = new boolean[numbers.length];
        dfs("", visited);
        return answer;
    }
    
    public void dfs(String str, boolean[] visited) {
        if (str.length() >= 1) {
            int val = Integer.parseInt(str);
            if (isPrime(val) && !set.contains(val)) {
                set.add(val);
                answer += 1;
            }       
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            dfs(str + numbers[i], visited);
            visited[i] = false;
        }
    }
}