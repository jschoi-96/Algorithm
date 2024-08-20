import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        int lo = 1;
        int hi = 1;

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > lo) lo = arr[i];
            hi += arr[i];
        }

        // 최소 금액 -> lowerbound

        while(lo <= hi) {
            int count = 1;
            long sum = 0;
            int mid = lo + (hi - lo) / 2;

            for(int num : arr) {
                sum += num;
                if (sum > mid) {
                    sum = num;
                    count++;
                }
            }
            if (count <= m) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
//             System.out.println("count: " + count + " lo: " + lo + " hi: " + hi);
        }
        System.out.println(lo);
    }
}
