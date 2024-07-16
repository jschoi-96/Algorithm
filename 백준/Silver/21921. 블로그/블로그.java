import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n, x; // n: 일 수, x: 구간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int hi = 0;
        int res = arr[0];
        int max = Integer.MIN_VALUE;
        int count = 1;

        for(int lo = 0; lo < n; lo++) {
            while (hi < n && hi - lo + 1 < x) {
                hi++;
                if (hi != n) res += arr[hi];
            }

            if (hi - lo + 1 < x) break;

            if (res > max) count = 1;
            else if (res == max) count++;

            max = Math.max(max , res);
            res -= arr[lo];

        }

        if (max == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}