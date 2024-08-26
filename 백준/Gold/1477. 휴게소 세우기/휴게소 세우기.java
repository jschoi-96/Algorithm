import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 휴게소가 없는 구간의 최대값을 먼저 찾는다.
    // 휴게소가 있는 곳에 휴게소를 세울 수 없고, 고속도로 끝에도 세울 수 없다.
    static int n, m, l;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n+2];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr[0] = 0;
        arr[n+1] = l;
        Arrays.sort(arr);

        int lo = 1, hi = l-1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;

            for(int i = 1; i < arr.length; i++) {
                int dist = arr[i] - arr[i-1] - 1;
                cnt += (dist / mid);
            }

            if (cnt <= m) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }
}
