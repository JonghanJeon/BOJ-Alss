import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int testCase = 1 ; testCase <= N ; testCase ++){
            int target = Integer.parseInt(br.readLine());
            if(check(target))
                sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.printf(sb.toString());
    }

    public static boolean check(int target){
        for(int  B = 2 ; B <= 64 ; B ++){
            ArrayList<Integer> list = new ArrayList<>();
            int number = target;
            while(number > 0){
                list.add(number%B);
                number = number / B;
            }
            ArrayList<Integer> list2 = new ArrayList<>(list);
            Collections.reverse(list2);
            if(list.equals(list2))
                return true;
        }
        return false;
    }
}