import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, hi = 0;
        int res = 0;
        for(int lo = 0; lo < n; lo++) {
            while(hi < n && sum < m) {
                sum += arr[hi++];
            }

            if (sum == m) {
                res++;
            }
            sum -= arr[lo];
        }
        System.out.println(res);
    }
}
