import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sum = new int[n+1];
        sum[0] = 0;
        int res = 0;
        for(int i = 1; i <= n; i++) {
            sum[i] = arr[i-1] + sum[i-1]; // sum[1] = arr[0] + sum[0];
            res += sum[i];
        }

        System.out.println(res);
    }
}
