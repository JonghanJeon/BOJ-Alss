import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		// 중복제거
		Set<String> uniqueSet = new HashSet<>(Arrays.asList(arr));

		// 배열 변환
		/*
		만약 new String[0] 대신 new String[uniqueSet.size()]와 같이 크기를 지정하면 결과로 반환되는 배열의 크기가 uniqueSet의 크기로 고정되게 됩니다. 
		그러나 크기를 0으로 지정하면 toArray 메서드가 적절한 크기로 자동으로 배열을 생성합니다.
		 */
		String[] uniqueArr = uniqueSet.toArray(new String[0]);

		Arrays.sort(uniqueArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				else if (o1.length() < o2.length()) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});

		StringBuilder sb = new StringBuilder();

		for (String str : uniqueArr) {
			sb.append(str).append("\n");
		}

		System.out.println(sb);
	}
}