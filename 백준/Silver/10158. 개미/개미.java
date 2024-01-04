import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int answerX = (x + t) % (2*width);
        int answerY = (y + t) % (2*height);

        if(answerX > width)
            answerX = 2*width - answerX;
        if(answerY > height)
            answerY = 2*height - answerY;

        sb.append(answerX).append(" ").append(answerY);
        System.out.println(sb);
    }
}