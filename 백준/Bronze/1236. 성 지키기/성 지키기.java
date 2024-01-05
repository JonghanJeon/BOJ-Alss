import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String [][] strArr = new String[N][M];

        for(int i = 0; i < N ; i ++){
            String [] arr = br.readLine().split("");
            for(int j = 0; j < M ; j++){
                strArr[i][j] = arr[j];
            }
        }

        int rowCnt = N;
        int colCnt = M;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(strArr[i][j].equals("X")){
                    rowCnt --;
                    break;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(strArr[j][i].equals("X")){
                    colCnt --;
                    break;
                }
            }
        }
        
        if(colCnt >= rowCnt)
            System.out.println(colCnt);
        else if (colCnt < rowCnt)
            System.out.println(rowCnt);
    }
}