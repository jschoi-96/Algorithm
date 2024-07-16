import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int lo = i;
            int hi = n;
            int target = arr[lo] + m;

            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] < target) { // arr[mid]를 더 크게
                    lo = mid + 1;
                }

                else {
                    hi = mid - 1;
                }

                int res = Math.abs(arr[hi] - arr[i]);
                if (res >= m) {
                    min = Math.min(res, min);
                }

                if (res == m) break;
            }
        }
        System.out.println(min);

    }
}

