import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][2];

        Diff [] diff = new Diff[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;

            diff[i] = new Diff(i, a-b);
        }

        Arrays.sort(diff, (o1, o2) -> (o2.value - o1.value));


        int res = 0;
        for (int i = 0; i < n; i++) {
            int value = diff[i].value;

            int check = (n - 1 - i) * 1000 + 5000; // 첫날 = 7000원 이상, 둘째날 = 6000원, 셋째날, 5000원 ...
            if (x >= check && value > 0) {
                x -= 5000;
                // res += arr[i][0];
                res += arr[diff[i].idx][0];
            }

            else {
                x -= 1000;
                // res ++ arr[i][1];
                res += arr[diff[i].idx][1];
            }
        }
        System.out.println(res);
    }
}

class Diff {
    int idx;
    int value;
    public Diff(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}
