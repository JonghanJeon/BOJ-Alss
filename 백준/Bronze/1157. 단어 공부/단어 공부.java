import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase();
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : arr){
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }

        int max = 0;
        for(char key : map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
            }
        }

        char answer = ' ';
        int count = 0;
        for(char key : map.keySet()){
            if(map.get(key) == max){
                count ++;
                answer = key;
            }
            if(count == 2){
                answer = '?';
                break;
            }
        }

        System.out.println(answer);
    }
}