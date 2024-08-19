import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        long hi = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > hi) hi = arr[i];
        }

        long lo = 0;

        // 총합을 어떻게 구할까?

        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            int total = 0;

            for(int num : arr) {
                if (mid == 0) mid = 1;
                total += (num / mid);
            }

            if (total < k) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        System.out.println(lo - 1);
    }
}
