import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 메시지의 길이
		int C = Integer.parseInt(st.nextToken()); // 최대 숫자

		Set<Integer> set = new TreeSet<>();

		String[] numberStringArray = br.readLine().split(" ");
		List<Number> numbers = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(numberStringArray[i]);
			// 등장했다면
			if (set.contains(number)) {
				for (Number target : numbers) {
					if (target.number == number) {
						target.frequency += 1;
						break;
					}
				}
			} else { // 등장하지 않았다면
				numbers.add(new Number(number, i, 1));
				set.add(number);
			}
		}

		Collections.sort(numbers, new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				if (o1.frequency != o2.frequency)
					return o2.frequency - o1.frequency;
				else
					return o1.firstIndex - o2.firstIndex;
			}
		});

		StringBuilder sb = new StringBuilder();

		for (Number number : numbers) {
			for (int i = 0; i < number.frequency; i++) {
				sb.append(number.number).append(" ");
			}
		}

		System.out.println(sb);
	}

	public static class Number {
		int number; // 숫자
		int firstIndex; // 첫 등장 인덱스
		int frequency; // 빈도수

		public Number(int number, int firstIndex, int frequency) {
			this.number = number;
			this.firstIndex = firstIndex;
			this.frequency = frequency;
		}
	}
}

