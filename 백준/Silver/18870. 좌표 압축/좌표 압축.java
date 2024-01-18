import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] initArr = br.readLine().split(" ");
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(initArr[i]);
		}

		Set<Integer> set = new TreeSet<Integer>(Arrays.asList(arr));

		Map<Integer, Integer> map = new HashMap<>();

		int idx = 0;
		for (int num : set) {
			if (!map.containsKey(num)) {
				map.put(num, idx);
				idx++;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}

		System.out.println(sb);
	}
}

