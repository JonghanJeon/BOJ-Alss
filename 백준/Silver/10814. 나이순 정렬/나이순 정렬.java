import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Member> members = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int idx = i;
			members.add(new Member(age, name, idx));
		}

		Collections.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age != o2.age)
					return o1.age - o2.age;
				else
					return o1.idx - o2.idx;
			}
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(members.get(i).age).append(" ").append(members.get(i).name).append("\n");
		}

		System.out.println(sb);
	}

	public static class Member {
		int age;
		String name;
		int idx;

		public Member(int age, String name, int idx) {
			this.age = age;
			this.name = name;
			this.idx = idx;
		}
	}
}