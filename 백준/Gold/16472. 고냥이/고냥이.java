import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int left = 0, right = 0;

		int[] counter = new int[26];

		int count = 0, answer = 0;
		while (right < arr.length) {

			if (counter[arr[right] - 'a'] == 0) {
				count++;
			}
			counter[arr[right] - 'a']++;

			while (N < count) {
				counter[arr[left] - 'a']--;
				if (counter[arr[left] - 'a'] == 0) {
					count--;
				}
				left++;
			}

			answer = Math.max(answer, right - left + 1);
			right++;
		}

		System.out.println(answer);
	}
}