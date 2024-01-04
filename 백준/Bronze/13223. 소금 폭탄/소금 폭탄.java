import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = br.readLine().split(":");
        int initHour = Integer.parseInt(arr[0]);
        int initMin = Integer.parseInt(arr[1]);
        int initSec = Integer.parseInt(arr[2]);

        int initTime = initHour*3600 + initMin*60 + initSec;

        arr = br.readLine().split(":");
        int finalHour = Integer.parseInt(arr[0]);
        int finalMin = Integer.parseInt(arr[1]);
        int finalSec = Integer.parseInt(arr[2]);

        int finalTime = finalHour*3600 + finalMin*60 + finalSec;

        int ONEDAYTIME = 24*3600;

        int answerHour = 0;
        int answerMin = 0;
        int answerSec = 0;

        int resultTime = 0;

        if(finalTime <= initTime)
            resultTime = ONEDAYTIME - initTime + finalTime;
        else resultTime = finalTime - initTime;

        answerSec = resultTime % 60;
        answerMin = (resultTime / 60) % 60;
        answerHour = resultTime / 3600;

        System.out.printf("%02d:%02d:%02d", answerHour, answerMin, answerSec);
    }
}