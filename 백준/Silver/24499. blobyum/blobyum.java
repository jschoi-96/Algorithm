import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long window = 0;
        long max = 0;
        for(int i = 0; i < n + k; i++) {
            window += arr[i % n];
            if (i >= k - 1) {
                max = Math.max(max, window);
                window -= arr[(i - (k - 1)) % n];
            }

        }
        System.out.println(max);
    }
}
