import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> map = new HashMap<>(){{
            put(0, "0");
            put(1, "1");
            put(2, "2");
            put(3, "3");
            put(4, "4");
            put(5, "5");
            put(6, "6");
            put(7, "7");
            put(8, "8");
            put(9, "9");
            put(10, "A");
            put(11, "B");
            put(12, "C");
            put(13, "D");
            put(14, "E");
            put(15, "F");
            put(16, "G");
            put(17, "H");
            put(18, "I");
            put(19, "J");
            put(20, "K");
            put(21, "L");
            put(22, "M");
            put(23, "N");
            put(24, "O");
            put(25, "P");
            put(26, "Q");
            put(27, "R");
            put(28, "S");
            put(29, "T");
            put(30, "U");
            put(31, "V");
            put(32, "W");
            put(33, "X");
            put(34, "Y");
            put(35, "Z");
        }};

        while(N > B){
            sb.append(map.get(N%B));
            N = N / B;
        }

        if(N == B)
            sb.append("01");
        else sb.append(map.get(N));

        System.out.printf(sb.reverse().toString());
    }
}