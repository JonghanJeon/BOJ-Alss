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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = Arrays.stream(arr).max().getAsInt();
		int left = 1;
		int right = N * 10000;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid < max){
				left = mid + 1;
			}else {
				int count = getCnt(mid);
				if(count <= M)
					right = mid - 1;
				else left = mid + 1;
			}
		}

		System.out.println(left);
	}

	public static int getCnt(int current) {
		int cnt = 1;
		int currentAmount = current;
		for (int useAmount : arr) {
			if(currentAmount < useAmount) {
				cnt ++;
				currentAmount = current;
			}
			currentAmount -= useAmount;
		}
		return cnt;
	}
}