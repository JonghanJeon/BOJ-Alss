import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int [] target;
	
	public static int bs(int[] arr, int target) {
		int low = 0;
		int high = N-1;
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == target) return 1;
			else if(arr[mid] > target) high=mid-1;
			else low = mid+1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		target = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) target[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		for(int i=0; i<M; i++) {
			System.out.println(bs(arr, target[i]));
		}
	}
}
