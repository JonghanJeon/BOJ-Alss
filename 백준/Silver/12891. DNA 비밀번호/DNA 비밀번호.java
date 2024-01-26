import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		int S = Integer.parseInt(arr[0]); int P = Integer.parseInt(arr[1]);
		String pw = br.readLine();
		// String pw = s.substring(0, P);
		String [] numArr = br.readLine().split(" ");
		int a = Integer.parseInt(numArr[0]);
		int c = Integer.parseInt(numArr[1]);
		int g = Integer.parseInt(numArr[2]);
		int t = Integer.parseInt(numArr[3]);
		
		int answer = 0;
		
		int cnt_a = 0; int cnt_c = 0; int cnt_g = 0; int cnt_t = 0;

		for(int i = 0; i < P; i++) {
			char ch = pw.charAt(i);
			if(ch == 'A') cnt_a += 1;
			else if(ch == 'C') cnt_c += 1;
			else if(ch == 'G') cnt_g += 1;
			else if(ch == 'T') cnt_t += 1;
		}
		
		if(cnt_a >= a && cnt_c >= c && cnt_g >= g && cnt_t >= t) answer += 1;

		for(int j = 1; j< S-P+1; j++) {
			char del = pw.charAt(j-1); char add = pw.charAt(j+P-1);
			if(del == 'A') cnt_a -= 1;
			else if(del == 'C') cnt_c -= 1;
			else if(del == 'G') cnt_g -= 1;
			else if(del == 'T') cnt_t -= 1;
			if(add == 'A') cnt_a += 1;
			else if(add == 'C') cnt_c += 1;
			else if(add == 'G') cnt_g += 1;
			else if(add == 'T') cnt_t += 1;
			
			if(cnt_a >= a && cnt_c >= c && cnt_g >= g && cnt_t >= t) answer += 1;
		}
		
		System.out.println(answer);


	}
}
