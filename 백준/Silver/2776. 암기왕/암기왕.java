import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t, n, m;
    static int [] arr1, arr2;
    static StringBuilder sb = new StringBuilder();
    // 100만 -> nlog(n)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());


        for(int test = 0; test < t; test++) {
            n = Integer.parseInt(br.readLine());
            arr1 = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);

            m = Integer.parseInt(br.readLine());
            arr2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                int lo = 0;
                int hi = n - 1;

                boolean flag = false;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;

                    if (arr1[mid] < arr2[i]) {
                        lo = mid + 1;
                    } else if (arr1[mid] > arr2[i]) {
                        hi = mid - 1;
                    } else {
                        sb.append(1).append("\n");
                        flag = true;
                        break;
                    }
                }

                if (!flag)
                    sb.append(0).append("\n");
                flag = false;
            }
        }
        System.out.println(sb);
    }
}
