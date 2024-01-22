import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;
	public static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		find(M);

		System.out.println(answer);
	}

	public static boolean isPossible(int setHeight, int thresholdHeight){
		long sum = 0;
		for(int height : arr){
			if (height > setHeight) sum += height - setHeight;
		}
		return sum >= thresholdHeight;
	}

	public static void find(int thresholdHeight) {
		int left = 0, right = 1000000000;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (isPossible(middle, thresholdHeight)){
				answer = middle;
				left = middle + 1;
			}else right = middle - 1;
		}
	}
}