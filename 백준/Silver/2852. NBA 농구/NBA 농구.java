import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] score = new int[2];
        int[] winTime = new int[2];
        int prev = 0;
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] str = input.split(" ");
            int time = Integer.parseInt(str[0]) - 1;

            String[] t = str[1].split(":");
            int m = Integer.parseInt(t[0]);
            int s = Integer.parseInt(t[1]);
            int total = m*60+s;

            if (score[0] > score[1]) winTime[0] += total - prev;
            else if (score[1] > score[0]) winTime[1] += total - prev;

            prev = total;
            score[time]++;
        }

        int total = 48 * 60;

        if (score[0] > score[1]) winTime[0] += total - prev;
        else if (score[1] > score[0]) winTime[1] += total - prev;
        System.out.println(convert(winTime[0]));
        System.out.println(convert(winTime[1]));
    }

    public static String convert(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds); // 두 자리로 포맷팅
    }
}
