import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int allVote = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        List<Staff> list = new ArrayList<>();

        // 5% 미만 짤라내기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String staffName = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());

            if(((float) votes/(float) allVote * 100) < 5)
                continue;

            list.add(new Staff(staffName, votes));
        }

        list.sort((Comparator.comparing(staff -> staff.name)));

        for(Staff staff : list){
            for (int i = 1; i <= 14; i++) {
                staff.arr.offer(staff.votes / i);
            }
        }

        int count = 1;
        while (count <= 14){
            int max = 0;
            int num = 0;
            for (int i = 0; i < list.size(); i++) {
                Staff staff = list.get(i);
                int peek = staff.arr.peek();
                if(peek > max){
                    max = peek;
                    num = i;
                }
            }
            Staff staff = list.get(num);
            staff.arr.poll();
            staff.chip ++;
            count ++;
        }

        list.forEach(staff -> System.out.println(staff.name + " " + staff.chip));
    }
}

class Staff {
    String name;
    int votes;
    int chip = 0;
    Queue<Integer> arr= new LinkedList<>();

    public Staff(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }
}