package weekendWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;



public class B1414_불우이웃_최소스패닝트리사용 {
	static int N;
	static int [][] map;
	static int [] rootInfo;
	static int [] weight;
	static ArrayList<Node> list;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		rootInfo = new int[N];
		weight = new int [N];
		list = new ArrayList<>();
		Arrays.fill(weight, 0);
		Arrays.setAll(rootInfo, (i)->i);
		for(int i=0; i<N; i++) {
			String[] strs = br.readLine().split("");
			for(int j=0; j<N; j++) {
				if(Character.isUpperCase(strs[j].charAt(0))) { // 대문자일때
					map[i][j] = strs[j].charAt(0)-38;
				}else if(Character.isLowerCase(strs[j].charAt(0))) { // 소문자일떄
					map[i][j] = strs[j].charAt(0)-96;
				}else map[i][j] = 0;
			}
		}
		
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				// 같은 노드 끼리 연결된거 빼기
				if(i == j) {
					total += map[i][j];
					continue;
				}
				total += map[i][j];
				total += map[j][i];
				// 가중치 0인건 빼기
				if(map[i][j] != 0) {
					list.add(new Node(i, j, map[i][j]));
				}
				if(map[j][i] != 0) {
					list.add(new Node(j, i, map[j][i]));					
				}
			}
		}
		// 정렬
		Collections.sort(list, (line1, line2) ->{
			return line1.weight - line2.weight;
		});
		int weightSum = 0;
		for(int i=0; i<list.size(); i++) {
			int node1 = list.get(i).n1;
			int node2 = list.get(i).n2;
			if(find(node1) == find(node2)) continue;
			union(node1, node2);
			weightSum += list.get(i).weight;
		}
		for(int i=0; i<N; i++) {
			if(find(0) != find(i)) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		// 전체 선에서 최소 스패닝 트리 가중치 합 뺴기
		System.out.println(total - weightSum);
	}
	
	public static int find(int x) {
        if (x == rootInfo[x]) {
            return x;
        }
        return rootInfo[x] = find(rootInfo[x]);
    }

	public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) rootInfo[y] = x;
            else rootInfo[x] = y;
        }
    }
	
}
class Node{
	public int n1;
	public int n2;
	public int weight;
	public Node(int n1, int n2, int weight) {
		this.n1 = n1;
		this.n2 = n2;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "[" + n1 + ", " + n2 + ", " + weight + "]";
	}
	
}