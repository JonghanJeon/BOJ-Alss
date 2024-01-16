import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean[] arr = new boolean[10001];
		for (int i = 0; i < arr.length; i++)
			arr[i] = true;
        int number = 1;
        while(number < 10000){
            int result = d(number);
            number ++;
            if(result > 10000){
                continue;
            }else arr[result] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++){
            if(arr[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb);
	}

	public static int d(int n){
	    String number = n + "";
        int sum = n;
        for (int i = 0; i < number.length(); i++) {
            sum = sum + Character.getNumericValue(number.charAt(i));
        }
        return sum;
	}
}