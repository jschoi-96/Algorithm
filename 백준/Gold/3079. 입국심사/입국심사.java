import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n, m; // n: 입국 심사대 개수, m: 사람 수
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[n];

        long lo = 1;
        long hi = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > hi) hi = arr[i];
        }

        hi = (long) (hi * m);


        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long result = 0;
            for(int i = 0; i < arr.length; i++) {
                result += (mid / arr[i]); // 30 / 7 + 30 / 10 = 7
                if (result >= m) break;
            }

            if (result < m) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        System.out.println(lo);
    }
}