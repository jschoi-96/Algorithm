import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n, s; // 길이, 부분합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(arr); // nlogn -> 10000 * 100
        // 1 2 3 4 5 5 7 8 9 10
        int min = Integer.MAX_VALUE;

        int hi = 0;
        long sum = arr[0];
        for(int lo = 0; lo < n; lo++) {
            while(hi < n && sum < s) {
                hi++;
                if (hi != n) sum += arr[hi];
            }

            if (hi == n) break; // 범위 벗어날 시 종료 
            // sum이 s보다 커졌을 때
            min = Math.min(min, hi - lo + 1);
            sum -= arr[lo];
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else System.out.println(min);
    }
}