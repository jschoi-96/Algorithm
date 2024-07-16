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
        int [] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int hi = 0;
        for(int lo = 0; lo < n; lo++) {

            while(hi < n && arr[hi] - arr[lo] < m) hi++;

            if (hi == n) break;
            min = Math.min(min, arr[hi] - arr[lo]);
        }

        System.out.println(min);
    }
}

