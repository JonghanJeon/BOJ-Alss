import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int budget = Integer.parseInt(br.readLine());

		long left = 1, right = Arrays.stream(arr).max().getAsInt();
		while (left <= right){
			long mid = (left + right) / 2;
			long sum = getSum(mid);
			if(sum <= budget)
				left = mid + 1;
			else right = mid - 1;
		}

		System.out.println(right);
	}

	public static long getSum(long upperLimit){
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] <= upperLimit)
				sum += arr[i];
			else
				sum += upperLimit;
		}
		return sum;
	}
}