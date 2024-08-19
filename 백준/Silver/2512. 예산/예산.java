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
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        Arrays.sort(arr); // 110 120 140 150

        int lo = 0;
        int hi = arr[n-1];
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long result = 0;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) result += mid;
                else result += arr[i];
            }

            if (result <= m) {
                lo = mid + 1;
            }

            else {
                hi = mid - 1;
            }
        }
        System.out.println(hi);
    }
}