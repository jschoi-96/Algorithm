import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int lo = 0; int hi = 0;

        while(lo < n && hi < m) {
            if (arr1[lo] <= arr2[hi]) {
                sb.append(arr1[lo] + " ");
                lo++;
            }

            else {
                sb.append(arr2[hi] + " ");
                hi++;
            }
        }

        while(lo < n) {
            sb.append(arr1[lo] + " ");
            lo++;
        }

        while (hi < m) {
            sb.append(arr2[hi] + " ");
            hi++;
        }

        System.out.println(sb);


    }
}