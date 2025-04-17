import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int lo = 0, hi = n - 1;
        int res = Integer.MAX_VALUE;

        boolean isMinus = false;
        while(lo < hi) {
            int sum = arr[lo] + arr[hi];
            int abs = Math.abs(sum);

            if (abs < res) {
                if (sum < 0) isMinus = true;
                else isMinus = false;
                res = abs;
            }

            if (sum < 0) lo++;
            else if (sum > 0) hi--;
            else {
                System.out.println(sum);
                return;
            }
        }

        if (isMinus) System.out.println(-res);
        else System.out.println(res);
    }
}