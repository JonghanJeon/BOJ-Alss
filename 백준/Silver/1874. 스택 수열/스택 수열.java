import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int [] arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack <Integer> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();

		int num = 1; int arrIdx = 0;

		while(arrIdx < n) {
			if(stack.isEmpty()) { // 스택이 비어있다면 push
				stack.push(num);
				num++;
				sb.append("+\n");
				continue;
			}
			
			// 스택이 비어있지 않을떄 //
			if(stack.peek() > arr[arrIdx]) break; // 스택 맨 위값이 뽑아내야할 값보다 크다면 break;
			else if(stack.peek() == arr[arrIdx]) { // 스택 맨 위값이 뽑아내야할 값이랑 같다면 pop
				stack.pop();
				sb.append("-\n");
				arrIdx++;
			}else if(stack.peek() < arr[arrIdx]) { // 스택 맨 위값이 뽑아내야할 값보다 작다면 push
				stack.push(num);
				num++;
				sb.append("+\n");
			}
			
		}
		
		if(stack.isEmpty()) System.out.println(sb);
		else System.out.println("NO");
	}
}
