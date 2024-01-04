import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = br.readLine().split("");
        String[] str = br.readLine().split("");

        int count = 0;
        boolean equal = false;
        for(int idx = 0 ; idx < arr.length; idx ++){
            equal = false;
            if((idx + str.length - 1) < arr.length && arr[idx].equals(str[0])){
                equal = true;
                for(int i = 1; i < str.length; i++){
                    if(!arr[idx + i].equals(str[i])){
                        equal = false;
                        break;
                    }
                }
            }
            if(equal){
                count ++;
                idx += str.length-1;
            }
        }
        System.out.println(count);
    }
}