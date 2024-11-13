import java.io.*;
import java.util.*;
 
 
public class Solution {
     
    static class Pair {
        int sum; boolean isA; int cnt;
         
        Pair(int sum, boolean isA, int cnt) {
            this.sum = sum;
            this.isA = isA;
            this.cnt = cnt;
        }
    }
     
    static int T;
    static String num;
    static StringBuilder answer;
    static boolean[] visited;
    static boolean isPossible;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = new StringBuilder();
         
        T = Integer.parseInt(br.readLine());
         
        for (int no = 1; no <= T; no++) {
//          System.out.println("no = " + no);
            num = br.readLine();
            visited = new boolean[num.length()];
            isPossible = false;
            dfs("");
             
            if (isPossible) answer.append("#" + no + " ").append("possible\n");
            else answer.append("#" + no + " ").append("impossible\n");
        }
         
        System.out.println(answer.toString());
    }
     
    public static void dfs(String str) {
        if (str.length() == num.length() && Integer.parseInt(str) % Integer.parseInt(num) == 0 && Integer.parseInt(str) > Integer.parseInt(num)) isPossible = true;
         
        if (isPossible) return;
         
        for (int i = 0; i < num.length(); i++) {
            if (visited[i]) continue;
            if (str.length() == 0 && num.substring(i, i + 1).equals("0")) continue;
             
            visited[i] = true;
            dfs(str + num.substring(i, i + 1));
            visited[i] = false;
        }
    }
}