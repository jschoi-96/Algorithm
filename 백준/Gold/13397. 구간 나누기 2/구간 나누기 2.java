import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    // 1. 일단 m개의 구간으로 어떻게 나눌것인가?
    // 2. m개 이하의 구간으로 나눴을 때의 최댓값 - 최솟값을 어떻게 구할것인가?
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int hi = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > hi) hi = arr[i];
        }


        int lo = 0; // lo = 0, hi = 7, mid = 4
        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if (solve(mid)) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }

    public static boolean solve(int mid) {
        int min = arr[0];
        int max = arr[0];

        int cnt = 1;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if ((max - min) > mid) {
                min = arr[i];
                max = arr[i];
                cnt++;
                if (cnt > m) return false;
            }
        }
        return true;
    }
}
