import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		int num = 0;
		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());
			arr[i] = arr[i - 1] ^ num;
		}

		StringBuilder sb = new StringBuilder();

		int result = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startIndex = Integer.parseInt(st.nextToken());
			int endIndex = Integer.parseInt(st.nextToken());
			result = result ^ (arr[endIndex] ^ arr[startIndex - 1]);
		}

		System.out.println(result);
	}
}