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

        int preSum = 0;
        for(int i = 0; i < k; i++) {
            preSum += arr[i];
        }

        int max = preSum;
        for(int i = k; i < n + k; i++) {
            preSum -= arr[i-k];
            preSum += arr[i % n];
            max = Math.max(max, preSum);
        }
        System.out.println(max);
    }
}
