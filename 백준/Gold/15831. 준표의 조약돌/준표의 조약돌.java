import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		char[] arr = br.readLine().toCharArray();

		int blackCnt = 0;
		int whiteCnt = 0;
		int left = 0;
		int answer = 0;

		for (int right = 0; right < N; right++) {
			if (blackCnt > B) {
				if (arr[left] == 'B')
					blackCnt--;
				else
					whiteCnt--;
				left++;
				right--;
				continue;
			}

			if (arr[right] == 'B') { // black
				blackCnt++;
			} else { // white
				whiteCnt++;
			}

			if (blackCnt <= B && whiteCnt >= W)
				answer = Math.max(answer, right - left + 1);
		}

		System.out.println(answer);
	}
}