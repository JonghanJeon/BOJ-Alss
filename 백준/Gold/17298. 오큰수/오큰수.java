import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		String [] strs = bf.readLine().split(" ");
		int strs_leng = strs.length;
		int [] ansArr = new int [N];
		
		Stack <Integer> stack = new Stack<>();
		
		for(int i=strs_leng-1; i>=0; i--) {
			int num = Integer.parseInt(strs[i]);
			if(stack.isEmpty()) {
				ansArr[i] = -1;
				stack.push(num);
				continue;
			}
			while(!stack.isEmpty()) {
				if(stack.peek() > num) {
					ansArr[i] = stack.peek();
					stack.push(num);
					break;
				}else stack.pop();
				
			}
			if(stack.isEmpty()) {
				ansArr[i] = -1;
				stack.push(num);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ansArr[0]);
		for(int i=1; i<ansArr.length; i++) {
			sb.append(" ");
			sb.append(ansArr[i]);
		}
		System.out.println(sb);
		
		
		
		
	}
}
