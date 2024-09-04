import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, l;
    static int [] area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        area = new int[m+1];
        for(int i = 0; i < m; i++) {
            area[i] = Integer.parseInt(br.readLine());
        }
        area[m] = l;


        for(int i = 0; i < n; i++) {
            int count = Integer.parseInt(br.readLine());
            int lo = 1; int hi = l; // 1 70, mid = 35
            int ans = 0;

            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (check(mid, count)) {
                    lo = mid + 1;
                    ans = Math.max(ans, mid);
                }

                else {
                    hi = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }

    public static boolean check(int mid, int k) {
        int prev = 0;
        for(int num : area) {
            if (num - prev >= mid) {
                k--;
                prev = num;
            }
        }

        if (k < 0) return true;
        return false;
    }
}
