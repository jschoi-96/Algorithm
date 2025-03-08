import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < k; i++) sum += arr[i];
        int max_sum = sum;

        for(int i = k; i < n; i++) {
            // System.out.println(sum)
            sum -= arr[i - k];
            sum += arr[i];
            max_sum = Math.max(max_sum, sum);
        }
        System.out.println(max_sum);
    }
}
