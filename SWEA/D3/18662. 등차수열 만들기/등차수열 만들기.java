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
    static StringBuilder answer;
    static double[] numbers;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = new StringBuilder();
         
        T = Integer.parseInt(br.readLine());
         
        for (int no = 1; no <= T; no++) {
//          System.out.println("no = " + no);
            st = new StringTokenizer(br.readLine());
            numbers = new double[3];
            for (int i = 0; i < 3; i++) {
                numbers[i] = Double.parseDouble(st.nextToken());
            }
             
            // 맨 앞에거 조절
            double gap = numbers[1] - numbers[2];
            double first = numbers[1] + gap;
            double result1 = Math.abs(first - numbers[0]);
//          System.out.println("result1 = " + result1);
             
            // 맨 뒤에거 조절
            gap = numbers[1] - numbers[0];
            double last = numbers[1] + gap;
            double result2 = Math.abs(last - numbers[2]);
//          System.out.println("result2 = " + result2);
             
            // 중간거 조절
            double mid = (numbers[0] + numbers[2]) / 2.0;
            double result3 = Math.abs(mid - numbers[1]);
//          System.out.println("result3 = " + result3);
             
            double result = Math.min(result1, result2);
            result = Math.min(result, result3);
            answer.append("#" + no + " ").append(String.format("%.1f", result)).append("\n");
             
        }
         
        System.out.println(answer.toString());
    }
}