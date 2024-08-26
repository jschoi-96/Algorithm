import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0;
        
        for(int i = 0; i < m; i++) {
            res += arr[i];
        }

        long tmp = res;
        for(int i = m; i < n; i++) { // 2일부터 4일
            tmp += arr[i] - arr[i-m]; //
            res = Math.max(res, tmp);
        }

        System.out.println(res);
    }
}
