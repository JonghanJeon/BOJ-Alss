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
        List<StaffChip> chipList = new ArrayList<>();

        // 5% 미만 짤라내기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String staffName = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());

            if(((float) votes/(float) allVote * 100) < 5)
                continue;

            chipList.add(new StaffChip(staffName));
            for (int j = 1; j <= 14; j++) {
                list.add(new Staff(staffName, votes/j));
            }
        }

        list.sort((Comparator.comparing(staff -> -staff.score)));
        chipList.sort((Comparator.comparing(staffChip -> staffChip.name)));

        for (int i = 0; i < 14; i++) {
            for(StaffChip staffChip : chipList){
                if(list.get(i).name.equals(staffChip.name))
                    staffChip.chip++;
            }
        }

        StringBuilder sb = new StringBuilder();
        chipList.forEach(o -> sb.append(o.name).append(" ").append(o.chip).append("\n"));

        System.out.println(sb);

    }
}

class Staff{
    String name;
    int score;

    public Staff(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class StaffChip{
    String name;
    int chip = 0;

    public StaffChip(String name) {
        this.name = name;
    }
}