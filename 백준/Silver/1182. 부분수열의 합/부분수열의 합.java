import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

import javax.swing.plaf.IconUIResource;

public class Main {

	static int N;
	static int S;
	static int[] arr;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		DFS(0, 0, 0);

		if (S == 0)
			answer--;
		System.out.println(answer);
	}

	static void DFS(int depth, int result, int start){
		if (result == S)
			answer++;
		if (depth == N) {
			return;
		}

		for (int i = start; i < N; i++) {
			DFS(depth + 1, result + arr[i], i + 1);
		}
	}
}