import java.util.*;
import java.io.*;

public class Main {
	
	static int[] W; //무게 배열
    static int[] V; //가치 배열
    static int[][] dp; //무게(열)와 물건(행)로 작성했던 그 테이블을 표현한 배열

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //물건 개수
        int K = Integer.parseInt(st.nextToken()); //배낭에 들어갈 수 있는 최대 무게 값

        W = new int[N + 1];
        V = new int[N + 1];

        dp = new int[N + 1][K+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= K; j++) {
        		if (j - W[i] >= 0) {
        			dp[i][j] = Math.max(dp[i - 1][j],  dp[i - 1][j - W[i]] + V[i]);
        		} else {
        			dp[i][j] = dp[i - 1][j];
        		}
        	}
        }
        
        System.out.println(dp[N][K]);
	}
}