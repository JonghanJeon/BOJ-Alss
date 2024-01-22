import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;
	public static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		find(N);
		System.out.println(answer);
	}

	public static void find(long N){
		long left = 0, right = N;
		while (left <= right){
			long middle = (left + right) / 2;
			if(N <= Math.pow(middle,2)){
				answer = middle;
				right = middle-1;
			}else left = middle + 1;
		}
	}

}