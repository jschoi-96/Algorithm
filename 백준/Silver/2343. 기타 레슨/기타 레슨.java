import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        st = new StringTokenizer(br.readLine());

        int hi = 0;
        int lo = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            hi += arr[i];
            lo = Math.max(lo, arr[i]);
        }

        // 9 45
        // 27
//        Arrays.sort(arr); // 10만 x
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int tmp = 0;
            int count = 0;

            for(int num : arr) {
                tmp += num;

                if (tmp > mid) {
                    count++;
                    tmp = num;
                }
            }

            if (tmp != 0) count++;

            if (count <= m) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }
}
