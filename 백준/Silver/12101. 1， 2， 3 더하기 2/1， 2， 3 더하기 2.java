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
    static int n, k;
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dfs(0 , "");

        if (res.size() < k) {
            System.out.println(-1);
            return;
        }
        String result = res.get(k-1);
        System.out.println(result.substring(0,result.length() - 1));
    }

    public static void dfs(int cur, String tmp) {
        if (cur == n) {
            res.add(tmp);
            //System.out.println(tmp);
            return;
        }

        if (cur + 1 <= n) dfs(cur + 1, tmp + "1+");
        if (cur + 2 <= n) dfs(cur + 2, tmp + "2+");
        if (cur + 3 <= n) dfs(cur + 3, tmp + "3+");
    }
}
