import java.util.*;
import java.io.*;

public class Solution {
	
	static class Car {
		int num;
		int weight;
		
		Car(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
	
	static int T, n, m, status;
	static int[] pays; // 주차 자리별 금액 저장
	static int[] cars; // 차량 번호에 무게 저장
	static int[] parking; // 주차 위치 - 차량 번호
	static int[] location; // 차량 번호 - 주차 위치
	static Queue<Integer> line;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int no = 1; no <= T; no++) {
			answer.append("#").append(no).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			pays = new int[n + 1];
			cars = new int[m + 1];
			parking = new int[n + 1];
			location = new int[m + 1];
			status = 0;
			line = new LinkedList<>();
			int result = 0;
			for (int i = 1; i <= n; i++) {
				pays[i] = Integer.parseInt(br.readLine());
			}
			
			for (int i = 1; i <= m; i++) {
				cars[i] = Integer.parseInt(br.readLine());
			}
			
			for (int i = 1; i <= 2 * m; i++) {
				int num = Integer.parseInt(br.readLine());
				if (num > 0) { // 입차
					if (status == n) { // 만차
						line.add(num);
					} else { // 자리있음
						for (int x = 1; x <= n; x++) {
							if (parking[x] == 0) {
								parking[x] = num;
								location[num] = x;
								result += (pays[x] * cars[num]);
								status++;
								break;
							}
						}
					}
				} else if (num < 0) { // 출차
					num *= -1;
					int parkingNum = location[num];
					location[num] = 0;
					if (line.size() > 0) {
						// 기다리는 차가 있으면
						int newCar = line.poll();
						location[newCar] = parkingNum;
						parking[parkingNum] = newCar;
						result += (pays[parkingNum] * cars[newCar]);
					} else {
						// 기다리는 차가 없으면
						parking[parkingNum] = 0;
						status--;
					}
				}
			}
			
			answer.append(result).append("\n");
		}
		
		System.out.println(answer.toString());
	}
}
