import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, d, k, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] cnt = new int[d + 1]; // 초밥의 초기 갯수 계산

        int unique = 0;
        for(int i = 0; i < k; i++) {
            if (cnt[arr[i]] == 0) unique++;
            cnt[arr[i]]++;
            // System.out.println(arr[i] + " " + cnt[arr[i]]);
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            int left = arr[i];
            cnt[left]--;
            if (cnt[left] == 0) {
                unique--;
            }

            int right = arr[(i + k) % n];
            if (cnt[right] == 0) {
                unique++;
            }
            cnt[right]++;

            int cur_len = unique;
            if (cnt[c] == 0) {
                cur_len++;
            }
            max = Math.max(max, cur_len);
        }
        System.out.println(max);
    }
}
