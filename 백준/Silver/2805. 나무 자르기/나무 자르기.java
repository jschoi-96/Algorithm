import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
        1. 자른 나무들의 총 합이 m이상이 되도록 높이를 설정해야 한다.
        2. 높이의 최댓값을 구해서 리턴
        3. 이분탐색의 시작 값은 최솟값, 끝 값은 나무의 최대 높이
     */
    static int n, m;
    static long [] arr;
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

        long max_h = binarySearch(m);
        System.out.println(max_h);
    }

    public static long binarySearch(int target) {
        long st = arr[0];
        long en = arr[arr.length - 1];

        while(st < en) {
            long mid = (st + en) / 2;

            long res = 0;
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    res += arr[i] - mid;
                }
            }

            if (res < target) {
                en = mid;
            }

            else {
                st = mid + 1;
            }
        }
        return en - 1;
    }
}
