import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		int start = 1, digit = 1;
		int end;
		while (true) {
			end = start * 2;
			if (start <= K && K <= end)
				break;
			else {
				start = end + 1;
				digit++;
			}
		}

		StringBuilder sb = new StringBuilder();
		int x;
		int digitCount = 0;
		while (digitCount < digit) {
			x = (end - start + 1) / 2;
			int tmp = start - 1 + x;
			if (K <= tmp) {
				end = tmp;
				sb.append(4);
			} else {
				start = tmp + 1;
				sb.append(7);
			}
			digitCount++;
		}

		System.out.println(sb);
	}
}