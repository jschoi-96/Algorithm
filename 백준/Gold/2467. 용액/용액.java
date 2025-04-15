import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Arrays.sort(arr);

        // 각 수의 합을 더해서 최솟값을 갱신한다. min = Math.min(min, Math.abs(a+b)) 이런식으로?
        // -1과 2가있을 때 0과 같은건 1이기 때문에.. 그리고 이때 a,b를 갱신해준다.
        long res = Long.MAX_VALUE;
        int lo = 0, hi = arr.length - 1;

        int [] ans = new int[2];
        while(lo < hi) {
            long sum = arr[lo] + arr[hi];
            long abs = Math.abs(sum);
            if (abs < res) {
                res = abs;
                // System.out.println(arr[lo] + " " + arr[hi]);
                ans[0] = arr[lo];
                ans[1] = arr[hi];
            }

            if (sum < 0) lo++;
            else hi--;
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
