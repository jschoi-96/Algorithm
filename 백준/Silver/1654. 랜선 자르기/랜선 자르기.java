import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int k, n;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];

        long max = 0;
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) max = arr[i];
        }

        long min = 0;
        max++;

        while(min < max) {
            long mid = (min + max) / 2;
            long result = 0;

            for(int i = 0; i < arr.length; i++) {
                result += (arr[i] / mid);
            }

            if (result < n) { // 현재 res가 n보다 작다는 것은, 상한을 낮춰야 함.
                max = mid;
            }

            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}
