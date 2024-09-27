import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // [1,3,6,6,7,9] [2,3,0,1,2]
        // [1,3] , [6,9] -> 2 + 3 = 5

        int [] tmp = new int[n];
        tmp[0] = arr[0];
        for(int i = 1; i < n; i++) {
            tmp[i-1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(tmp);
        int res = 0;
        for(int i = 0; i <= n - k; i++) {
            res += tmp[i];
        }
        System.out.println(res);
    }
}
