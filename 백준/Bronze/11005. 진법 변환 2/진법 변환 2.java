import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        char [] arr = new char [36];
        
        for(char c = '0'; c <= '9' ; c ++){
            arr[c-'0'] = c;
        }
        
        for(char c = 'A'; c <= 'Z' ; c ++){
            arr[c-'A'+10] = c;
        }

        while(N > B){
            sb.append(arr[N%B]);
            N = N / B;
        }

        if(N == B)
            sb.append("01");
        else sb.append(arr[N]);

        System.out.printf(sb.reverse().toString());
    }
}