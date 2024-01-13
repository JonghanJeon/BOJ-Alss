import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        char [] arr = new char [36];

        for(char c = '0'; c <= '9' ; c ++){
            arr[c-'0'] = c;
        }

        for(char c = 'A'; c <= 'Z' ; c ++){
            arr[c-'A'+10] = c;
        }

        while(N > 0){
            sb.append(arr[N%B]);
            N = N / B;
        }

        System.out.printf(sb.reverse().toString());
    }
}