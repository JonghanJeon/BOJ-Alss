import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static int[] lanArr;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lanArr = new int[K];
		for (int i = 0; i < K; i++) {
			lanArr[i] = Integer.parseInt(br.readLine());
		}

		long answer = getMaxWidth();

		System.out.println(answer);
	}

	public static int getLan(long currentWidth){
		int sum = 0;
		for (int i = 0; i < lanArr.length; i++) {
			sum += lanArr[i] / currentWidth;
		}
		return sum;
	}

	public static long getMaxWidth(){
		long left = 0, right = Integer.MAX_VALUE;
		long answer = -1;
		while (left <= right) {
			long mid = (left + right) / 2;
			int result = getLan(mid);
			if(N <= result){
				answer = mid;
				left = mid + 1;
			} else right = mid - 1;
		}
		return answer;
	}
}