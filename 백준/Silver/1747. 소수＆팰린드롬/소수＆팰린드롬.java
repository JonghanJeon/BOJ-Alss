import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N == 1) {
			System.out.println(2);
			System.exit(0);
		}
		A = new int [2_000_001];
		Arrays.setAll(A, (i)->i);
		for(int i=2; i < Math.sqrt(A.length); i++) {
			if(A[i] == 0) continue;
			for(int j=i+i; j < A.length; j+=i) 
				A[j] = 0;
		}
		int start = N;
		for(int i=N; i < A.length; i++) {
			if(A[i] == 0) continue;
			if(isPalindrome(A[i])) {
				System.out.println(A[i]);
				break;
			}
		}		
	}
	
	public static boolean isPalindrome(int num) {
		String s = Integer.toString(num);
		char [] arr = s.toCharArray();
		int front = 0;
		int back = arr.length-1;
		while(front < back) {
			if(arr[front] != arr[back])
				return false;
			front ++;
			back --;
		}
		return true;
	}
}
