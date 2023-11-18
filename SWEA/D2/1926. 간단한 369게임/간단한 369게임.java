import java.util.Arrays;
import java.util.Scanner;


public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.toString(i+1);
		}
		
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;
			for(int j=0; j<arr[i].length(); j++) {
				if(arr[i].charAt(j) != '0' && Character.getNumericValue(arr[i].charAt(j)) % 3 == 0) {
					cnt ++;
				}
			}
			if(cnt != 0) {
				String tmp = "";
				for(int x=0; x<cnt; x++)
					tmp += "-";
				arr[i] = tmp;
			}
		}
		
		for(String str:arr) {
			System.out.print(str + " ");
		}
	}
}