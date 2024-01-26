import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int left = 0, right = 0;
		int minGap = Integer.MAX_VALUE;
		while (right < N) {
			int currentGap = arr[right] - arr[left];
			if (currentGap < M)
				right ++;
			else if (currentGap == M) {
				minGap = currentGap;
				break;
			} else {
				minGap = Math.min(currentGap, minGap);
				left ++;
			}
		}

		System.out.println(minGap);
	}
}