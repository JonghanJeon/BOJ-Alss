import java.util.Scanner;

public class Main {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(1, 2);
		dfs(1, 3);
		dfs(1, 5);
		dfs(1, 7);
	}
	
	public static void dfs(int n, int num) {
		if(n == N) {
			if(isPrime(num)) System.out.println(num);
		}
		for(int i=1; i<10; i++) {
			if(isPrime(num*10+i)) {
				dfs(n+1, num*10 + i);
			}
		}
	}
	
	public static boolean isPrime(int num) {
		for (int i = 2; i<=(int)Math.sqrt(num); i++) {
	      if (num % i == 0) {
	          return false;
	      }
		}
		return true;
	}
}
