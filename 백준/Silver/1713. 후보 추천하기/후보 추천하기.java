import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
		int N = Integer.parseInt(br.readLine());
		int totalLike = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Student[] students = new Student[101];
		List<Student> list = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			students[i] = new Student(i, 0, 0, false);
		}

		for (int i = 0; i < totalLike; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 게시되어 있다면
			if(students[num].isPost)
				students[num].like++;
			else { // 게시되어 있지 않다면
				// 꽉 차 있는 경우
				if (list.size() == N) {
					Collections.sort(list, new Comparator<Student>() {
						@Override
						public int compare(Student o1, Student o2) {
							if (o1.like == o2.like)
								return o1.lastTime - o2.lastTime;
							else
								return o1.like - o2.like;
						}
					});
					//
					list.get(0).isPost = false;
					list.get(0).like = 0;
					list.get(0).lastTime = 0;
					list.remove(0);

					students[num].like++;
					students[num].lastTime = i;
					students[num].isPost = true;
					list.add(students[num]);
				} else { // 꽉 안찬 경우
					students[num].like++;
					students[num].lastTime = i;
					students[num].isPost = true;
					list.add(students[num]);
				}
			}
		}

		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.id - o2.id;
			}
		});

		for (Student s : list) {
			System.out.printf("%d ", s.id);
		}
	}

	static class Student {
		int id;
		int like;
		int lastTime;
		boolean isPost;

		public Student(int id, int like, int lastTime, boolean isPost) {
			this.id = id;
			this.like = like;
			this.lastTime = lastTime;
			this.isPost = isPost;
		}
	}
}