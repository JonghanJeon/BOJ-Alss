import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

import javax.swing.plaf.IconUIResource;

public class Main {

	static int N;

	static Egg[] eggList;

	static int answer;

	public static void main(String[] args) throws IOException {
		//INPUT
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggList = new Egg[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hp = Integer.parseInt(st.nextToken());
			int atk = Integer.parseInt(st.nextToken());
			eggList[i] = new Egg(hp, atk);
		}

		//LOGIC
		DFS(0, 0);

		System.out.println(answer);
	}

	static void DFS(int idx, int sum) {
		if (idx == N) {
			answer = Math.max(answer, sum);
			return;
		}

		Egg hand = eggList[idx];
		for (int i = 0; i < N; i++) {
			//TODO
			Egg next = eggList[i];
			if (i == idx)
				continue;

			boolean isHandBreak = false;
			boolean isNextBreak = false;
			boolean isCrash = false;
			//부딪힐 수 있다면
			if (hand.hp > 0 && next.hp > 0) {
				isCrash = true;
				if (hand.hp - next.atk <= 0) {
					sum++;
					isHandBreak = true;
				}
				if (next.hp - hand.atk <= 0) {
					sum++;
					isNextBreak = true;
				}
				hand.hp -= next.atk;
				next.hp -= hand.atk;
			}

			//NEXT
			DFS(idx + 1, sum);

			//RECOVERY
			if (isCrash) {
				if (isHandBreak)
					sum--;
				if (isNextBreak)
					sum--;
				hand.hp += next.atk;
				next.hp += hand.atk;
			}
		}
	}

	static class Egg {
		int hp;
		int atk;

		public Egg(int hp, int atk) {
			this.hp = hp;
			this.atk = atk;
		}
	}
}