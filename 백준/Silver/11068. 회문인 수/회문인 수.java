import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int testCase = 1 ; testCase <= N ; testCase ++){
            int target = sc.nextInt();
            if(check(target))
                sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.printf(sb.toString());
    }

    public static boolean check(int target){
        for(int  B = 2 ; B <= 64 ; B ++){
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            int number = target;
            while(number > 0){
                list.add(number%B);
                list2.add(number%B);
                number = number / B;
            }
            Collections.reverse(list2);
            if(list.equals(list2))
                return true;
        }
        return false;
    }
}