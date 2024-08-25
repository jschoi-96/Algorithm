import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [] arr;
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // nlog(n)

        // 5
        // -2 0 1 2 3
        // 1 2 3
        for(int i = 0; i < n; i++) {
            int lo = 0;
            int hi = n - 1;

            long target = arr[i];
            while(lo < hi) {

                if (lo == i) {
                    lo++;
                    continue;
                }

                if (hi == i) {
                    hi--;
                    continue;
                }
                if (arr[lo] + arr[hi] == target) {
                    // System.out.println("lo = " + arr[lo] + " hi = " + arr[hi] + " target = " + target);
                    count++;
                    break;
                }

                else if (arr[lo] + arr[hi] < target) {
                    lo++;
                }

                else if (arr[lo] + arr[hi] > target) {
                    hi--;
                }

            }
        }
        System.out.println(count);
    }
}
