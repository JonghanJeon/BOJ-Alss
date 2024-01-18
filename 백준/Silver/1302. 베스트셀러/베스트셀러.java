import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> books = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if (books.containsKey(name))
				books.put(name, books.get(name) + 1);
			else
				books.put(name, 1);
		}

		List<String> keySet = new ArrayList<>(books.keySet());
		Collections.sort(keySet, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (books.get(o1) > books.get(o2))
					return -1;
				else if (books.get(o1) < books.get(o2))
					return 1;
				else
					return o1.compareTo(o2);
			}
		});

		System.out.println(keySet.get(0));
	}
}