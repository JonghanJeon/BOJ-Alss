import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		if (A.length() == B.length()) {
			int cnt = 0;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i))
					cnt++;
			}
			System.out.println(cnt);
		} else {
			int testCase = B.length() - A.length();
			int min = Integer.MAX_VALUE;
			int cnt = 0;
			for (int i = 0; i <= testCase; i++) {
				cnt = 0;
				for (int j = 0; j < A.length(); j++) {
					if (A.charAt(j) != B.charAt(i + j))
						cnt++;
				}
				if (min > cnt)
					min = cnt;
			}
			System.out.println(min);
		}
	}

}