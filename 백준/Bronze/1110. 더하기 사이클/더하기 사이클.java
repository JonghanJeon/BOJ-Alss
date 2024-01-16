import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = N;

        int cnt = 0;
        while(true){

            int ten = num / 10;
            int one = num % 10;

            int sum = ten + one;

            num = (num % 10) * 10 + sum % 10;
            cnt ++;

            if(num == N)
                break;
        }
        System.out.println(cnt);
    }
}