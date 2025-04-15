import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int res = 0;
        int lo = 1;
        int hi = arr[arr.length-1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] / mid;
            }

            if (sum >= m) {
                res = mid;
                lo = mid + 1;
            }

            else hi = mid - 1;
        }

        System.out.println(res);
    }
}