import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (arr1, arr2) -> {
            if(arr1[1] == arr2[1]) {
                return arr1[0] - arr2[0];
            }
            return arr1[1] - arr2[1];
        });

        int cnt = 1;
        int end = arr[0][1];
        for(int i=1; i<N; i++) {
            if(arr[i][0] < end) continue;
            cnt ++;
            end = arr[i][1];
        }
        System.out.println(cnt);
    }
}