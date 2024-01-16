import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean notExist = true;
        for (int i = 1; i < N; i++) {
            String num = i + "";
            int sum = i;
            for (int j = 0; j < num.length(); j++) {
                sum += Character.getNumericValue(num.charAt(j));
            }
            if(sum == N) {
                notExist = false;
                System.out.println(i);
                break;
            }
        }
        if(notExist)
            System.out.println(0);
    }
}