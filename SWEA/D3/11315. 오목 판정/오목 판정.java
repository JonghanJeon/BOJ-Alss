import java.util.*;
import java.io.*;

class Solution {
	
	static int T, N;
	static StringBuilder answer = new StringBuilder();
	static int[][] map;
	
	// 가로 세로 우상대각 좌하대각
	static int[][] dx = {{0, 0, 0, 0}, {-2, -1, 1, 2}, {2, 1, -1, -2}, {-2, -1, 1, 2}};
	static int[][] dy = {{-2, -1, 1, 2}, {0, 0, 0, 0}, {-2, -1, 1, 2}, {-2, -1, 1, 2}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			answer.append("#").append(no).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					if (str.substring(j, j + 1).equals("o")) map[i][j] = 1;
				}
			}
			boolean isPossible = false;
			Loop1:
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < N; y++) {
						if (map[x][y] == 1) {
							for (int dir = 0; dir < 4; dir++) {
								if (check(x, y, dir)) {
									isPossible = true;
									break Loop1;
								}
							}
						}
					}
				}
			if (isPossible) answer.append("YES\n");
			else answer.append("NO\n");
		}
		
		System.out.println(answer.toString());
	}
	
	public static boolean check(int x, int y, int dir) { // 가로
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[dir][d];
			int ny = y + dy[dir][d];
			
			if (!inMap(nx, ny)) return false;
			if (map[nx][ny] == 0) return false;
		}
		
		return true;
	}
	
	public static boolean inMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}
}
