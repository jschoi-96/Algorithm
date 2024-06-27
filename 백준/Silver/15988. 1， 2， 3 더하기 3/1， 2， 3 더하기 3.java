import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*®®
    테이블: d[i]: 카드 i개를 만들 때 지불하는 금액의 최솟값∂®
    점화식: d[i] = Math.min(d[i], s[i] + d[i-j])
 */
public class Main {
    static int t,n;
    static long[] d = new long[1000002];
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        d[1] = 1; d[2] = 2; d[3] = 4;
        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            for(int j = 4; j <= n; j++) {
                d[j] = (d[j - 1] + d[j - 2] + d[j - 3]) %  1000000009;
            }
            System.out.println(d[n] % 1000000009);
        }
    }

}
