import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n; // 전체 용액의 수
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // arr[i]의 범위는 -10억~10억
        }
        Arrays.sort(arr); // -99 -2 -1 4 98

        int lo = 0;
        int hi = n - 1;

        int check = Integer.MAX_VALUE;
        int min = 0;
        int max = 0;

        while(lo < hi) {
            int result = arr[lo] + arr[hi];

            if (Math.abs(result) < check) { // check = 96
                check = Math.abs(result);
                min = arr[lo];
                max = arr[hi];
                if (check == 0) break;
            }

            if (result < 0) lo++;
            else hi--;
        }

        if (min == max) System.out.println(min);
        else System.out.println(min + " " + max);

    }
}