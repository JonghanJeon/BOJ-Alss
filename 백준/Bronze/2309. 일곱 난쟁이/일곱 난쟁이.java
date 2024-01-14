import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        boolean [] check = new boolean[9];

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            arr.add(x);
            check[i] = true;
        }

        Collections.sort(arr);
        
        // for 문 끝내기 위한 변수
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - arr.get(i) - arr.get(j) == 100){
                    check[i] = false;
                    check[j] = false;
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            if(check[i])
                sb.append(arr.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}