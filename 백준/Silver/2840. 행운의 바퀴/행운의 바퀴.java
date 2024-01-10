import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static String [] arr;
    public static boolean [] check;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new String[N];
        check = new boolean[26];

        st = new StringTokenizer(br.readLine());
        int idx = Integer.parseInt(st.nextToken());
        String item = st.nextToken();

        if(idx > N){
            idx = idx % N;
            arr[idx] = item;
        } else if (idx == N){
            arr[0] = item;
        } else arr[idx] = item;

        for (int i = 0; i < K-1; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            item = st.nextToken();

            idx = (idx + num) % N;

            if (arr[idx] == null){
                if(check[item.charAt(0)-'A']){
                    System.out.println("!");
                    System.exit(0);
                }else {
                    check[item.charAt(0)-'A'] = true;
                    arr[idx] = item;
                }
            } else {
                if (!arr[idx].equals(item)) {
                    System.out.println("!");
                    System.exit(0);
                }
            }
        }

        for (int i = idx; i >= 0 ; i--) {
            if(arr[i] == null)
                sb.append("?");
            else sb.append(arr[i]);
        }

        for (int i = N-1; i > idx ; i--) {
            if(arr[i] == null)
                sb.append("?");
            else sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}