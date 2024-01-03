import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(Character.isLowerCase(arr[i]))
                arr[i] = Character.toUpperCase(arr[i]);
            else arr[i] = Character.toLowerCase(arr[i]);
        }
        System.out.println(arr);
    }
}