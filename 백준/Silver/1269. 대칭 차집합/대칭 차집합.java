import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String [][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String [] setA = br.readLine().split(" ");
        String [] setB = br.readLine().split(" ");

        Set<String> arrA = new HashSet<>();
        Set<String> arrB = new HashSet<>();

        for(String str : setA){
            arrA.add(str);
        }
        for(String str : setB){
            arrB.add(str);
        }

        arrA.retainAll(arrB);

        int AB = A - arrA.size();
        int BA = B - arrA.size();

        System.out.println(AB + BA);
    }
}