import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase =  Integer.parseInt(st.nextToken());

        for(int testCaseNum  = 1 ; testCaseNum <= testCase ; testCaseNum ++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            int width;
            int height;
            if((N % H) == 0){
                height = H;
                width = N / H;
            } else {
                height = N % H;
                width = (N / H) + 1;
            }

            sb.append(height);

            if(width < 10)
                sb.append(0);
            sb.append(width);
            
            sb.append("\n");
        }
        System.out.println(sb);
    }
}