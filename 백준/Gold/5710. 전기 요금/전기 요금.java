import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 0 && b == 0)
				return;
			
			int total = getTotal(a);
			
			int left = 0; int right = total / 2;
			while (left <= right) {
				int mid = (left + right) / 2;
				
				int sPrice = calPrice(mid);
				int nPrice = calPrice(total - mid);
				
				int diff = Math.abs(sPrice - nPrice);
				if (diff < b) {
					right = mid - 1;
				} else if (diff > b) {
					left = mid + 1;
				} else {
					System.out.println(calPrice(mid));
					break;
				}
			}
		}
	}
	
	public static int calPrice(int watt) {
		if (watt <= 100) 
			return watt * 2;
		else if (watt <= 10000)
			return (watt - 100) * 3 + 200;
		else if (watt <= 1000000)
			return (watt - 10000) * 5 + 29900;
		else
			return (watt - 1000000) * 7 + 4979900;
	}
	
	public static int getTotal(int a) {
		if (a <= 200) 
			return a / 2;
		else if (a <= 29900) 
			return ((a - 200) / 3) + 100;
		else if (a <= 4979900)
			return ((a - 29900) / 5) + 10000;
		else
			return ((a - 4979900) / 7) + 1000000;
	}
}