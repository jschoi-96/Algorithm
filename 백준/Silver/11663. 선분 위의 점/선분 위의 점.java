import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*

     */
    static int n, m;
    static long [] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int result = bs(s, e);
            sb.append(result).append("\n");

        }
        System.out.println(sb.toString().trim());
    }

    public static int bs(int s, int e) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < s) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        int left = low;

        low = 0;
        high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > e) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        int right = high + 1;

        return right - left;
    }
}