import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        HashMap<Character, Integer> dic = new HashMap<>();
        for (char i = '0'; i <= '9'; i++) {
            dic.put(i, i-'0');
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            dic.put(i, i-'A'+10);
        }

        int result = 0;
        int number = 1;

        for (int i = str.length()-1; i >= 0 ; i--) {
            result = result + (dic.get(str.charAt(i)) * number);
            number *= B;
        }

        System.out.println(result);
    }
}