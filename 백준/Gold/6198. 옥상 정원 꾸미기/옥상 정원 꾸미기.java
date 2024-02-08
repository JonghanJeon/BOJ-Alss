import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import javax.imageio.plugins.tiff.TIFFTag;

public class Main {

	public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] buildings = new int[N];
		int[] hide = new int[N];

		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> height = new Stack<>();
		Stack<Integer> index = new Stack<>();
		long answer = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (height.isEmpty()) {
				height.push(buildings[i]);
				index.push(i);
				continue;
			}
			int currentBuildingHeight = buildings[i];
			int cnt = 0;
			while (!height.isEmpty() && height.peek() < currentBuildingHeight) {
				int idx = index.pop();
				height.pop();
				cnt += hide[idx] + 1;
			}
			hide[i] = cnt;
			answer += cnt;
			height.push(buildings[i]);
			index.push(i);
		}
		System.out.println(answer);
	}
}