import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : arr1){
            if(map1.containsKey(c))
                map1.put(c, map1.get(c)+1);
            else map1.put(c, 1);
        }
        for(char c : arr2){
            if(map2.containsKey(c))
                map2.put(c, map2.get(c)+1);
            else map2.put(c, 1);
        }

        int answer = 0;
        for(char key : map1.keySet()){
            if(map2.containsKey(key))
                answer += Math.abs(map1.get(key) - map2.get(key));
            else answer += map1.get(key);
        }
        for(char key : map2.keySet()){
            if(map1.containsKey(key))
                continue;
            else answer += map2.get(key);
        }

        System.out.println(answer);
    }
}