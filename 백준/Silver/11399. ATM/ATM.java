import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;

	public static void main(String[] argos) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			result += arr[i] * (N - i);
		}

		System.out.println(result);
	}
}
