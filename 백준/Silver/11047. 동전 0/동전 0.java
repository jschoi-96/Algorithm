import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 1억

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int div = k;
        int cnt = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > div) continue;
            else {
                while(div >= arr[i]) {
                    div -= arr[i];
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
