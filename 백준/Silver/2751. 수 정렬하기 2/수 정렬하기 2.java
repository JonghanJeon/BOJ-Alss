import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] minus = new boolean[1_000_001];
		boolean[] plus = new boolean[1_000_001];
		for (int i = 0; i < N; i++) {
			int index = Integer.parseInt(br.readLine());
			if(index < 0){
				minus[Math.abs(index)] = true;
			}else plus[index] = true;
		}

		StringBuilder sb= new StringBuilder();

		for (int i = 1_000_000; i >0; i--) {
			if(minus[i])
				sb.append(-i).append("\n");
		}

		for (int i = 0; i < 1_000_001; i++) {
			if(plus[i])
				sb.append(i).append("\n");
		}

		System.out.println(sb);
	}
}