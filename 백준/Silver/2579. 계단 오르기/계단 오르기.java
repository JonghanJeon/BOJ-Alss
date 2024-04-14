import java.io.*;
import java.util.*;

public class Main {

	static int N; // 계단의 개수
	static int[] STAIRS; // 계단 배열
	static int[] DP;

	public static void main(String[] argos) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		STAIRS = new int[N + 1];
		DP = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			STAIRS[i] = Integer.parseInt(br.readLine());
		}


		if (N == 1) {
			DP[1] = STAIRS[1]; // 첫번째 계단 최대값 고정
		} else if (N == 2) {
			DP[1] = STAIRS[1]; // 첫번째 계단 최대값 고정
			DP[2] = STAIRS[1] + STAIRS[2]; // 두번째 계단 최대값 고정
		} else if (N == 3) {
			DP[1] = STAIRS[1]; // 첫번째 계단 최대값 고정
			DP[2] = STAIRS[1] + STAIRS[2]; // 두번째 계단 최대값 고정
			DP[3] = Math.max(DP[1] + STAIRS[3], STAIRS[2] + STAIRS[3]);
		} else {
			DP[1] = STAIRS[1]; // 첫번째 계단 최대값 고정
			DP[2] = STAIRS[1] + STAIRS[2]; // 두번째 계단 최대값 고정
			DP[3] = Math.max(DP[1] + STAIRS[3], STAIRS[2] + STAIRS[3]);
			// 4부터는 두칸을 뛰어오거나 or 두칸을 뛰고 한칸을 뛰어오거나 둘중 하나
			for (int i = 4; i <= N; i++) {
				DP[i] = Math.max(DP[i - 2], DP[i - 3] + STAIRS[i - 1]) + STAIRS[i];
			}
		}

		System.out.println(DP[N]);
	}
}
