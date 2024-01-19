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
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] change = new int[N + 2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			change[a] += k;
			change[b + 1] += -k;
		}

		for (int i = 1; i <= N; i++) {
			change[i] = change[i - 1] + change[i];
			arr[i] += change[i];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb);
	}
}