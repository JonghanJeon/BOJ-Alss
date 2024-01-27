import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
		String [] strs = bf.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
        
		Queue <Integer> que = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
        
		sb.append("<");
        
		for(int i=1; i<N+1; i++) que.offer(i);
        
		for(int i=0; i<N; i++) {
			for(int j=1; j<K; j++) {
				int value = que.poll();
				que.offer(value);
			}
			int num = que.poll();
			sb.append(num);
			if(i != N-1) sb.append(", ");
		}
        
		sb.append(">");
        
		System.out.println(sb);
	}
}
