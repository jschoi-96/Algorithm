import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int [] arr = new int[n];
            int [] prefix = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = arr[0];
            prefix[0] = arr[0];
            for(int j = 1; j < n; j++) {
                if (prefix[j - 1] < 0) prefix[j - 1] = 0; // 누적합이 0보다 작은 경우엔 구간을 갱신해야함
                prefix[j] = prefix[j-1] + arr[j];
                max = Math.max(max, prefix[j]);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
