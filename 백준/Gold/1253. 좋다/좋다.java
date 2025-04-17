import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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

        Arrays.sort(arr);

        int cnt = 0;

        for(int i = 0; i < n; i++) {
            int lo = 0, hi = n - 1;
            while(lo < hi) {
                int sum = arr[lo] + arr[hi];
                if (i == lo) {
                    lo++;
                    continue; // continue를 하는건 한번에 한번의 포인터만 움직이게 하기 위함
                }

                if (i == hi) {
                    hi--;
                    continue;
                }

                if (sum == arr[i]) {
                    cnt++;
                    break;
                }

                else if (sum > arr[i]) hi--;
                else lo++;
            }
        }
        System.out.println(cnt);
    }
}
