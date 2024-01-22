import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] sums = new int[N * (N + 1) / 2];
		int sumsIndex = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				sums[sumsIndex] = arr[i] + arr[j];
				sumsIndex ++;
			}
		}

		Arrays.sort(sums);

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int target = arr[i] - arr[j];
				if (isExist(target, sums))
					answer = Math.max(answer, arr[i]);
			}
		}
		System.out.println(answer);
	}

	public static boolean isExist(int target, int[] sums){
		int left = 0, right = sums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if(sums[mid] == target)
				return true;
			else if (sums[mid] < target) {
				left = mid + 1;
			} else if (target < sums[mid]) {
				right = mid - 1;
			}
		}
		return false;
	}
}