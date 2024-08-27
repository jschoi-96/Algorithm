import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, c;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long lo = 1; long hi = arr[n-1] - arr[0];

        // 1 2 4 8 9 (기존집)
        // 1 2 4 5 (기존 집 사이의 거리)

        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2; // 4

            int count = 1;
            int last = arr[0];
            for(int i = 1; i < n; i++) {
                if (arr[i] - last >= mid) {
                    count++;
                    last = arr[i];
                }
            }


            if (count < c) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
            // System.out.println("lo: " + lo + " hi: " + hi);
        }
        System.out.println(lo - 1);
    }
}
