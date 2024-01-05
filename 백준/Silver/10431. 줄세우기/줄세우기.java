import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());

        for (int testCase = 1; testCase <= P; testCase++) {
            st = new StringTokenizer(br.readLine());
            int testCaseNum = Integer.parseInt(st.nextToken());
            int [] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for (int i = 0; i < 20; i++) {
                for (int j = i; j < 20; j++) {
                    if(arr[i] > arr[j])
                        cnt ++;
                }
            }

            System.out.println(testCase + " " + cnt);
        }
    }
}