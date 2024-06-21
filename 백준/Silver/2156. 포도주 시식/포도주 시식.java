import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i]: i번째 포도주를 선택했을 때 최대값
    점화식
        * d[i] = d[i-2] + s[i]
        * d[i] = d[i-3] + s[i-1] + s[i]
        * d[i] = d[i-1]
 */
public class Main {
    static int n;
    static int [] s = new int[10002];
    static int [] d = new int[10002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }

        d[1] = s[1];
        d[2] = s[1] + s[2];
        for(int i = 3; i <= n; i++) {
            d[i] = Math.max(Math.max(d[i-1], d[i-2] + s[i]), d[i-3] + s[i-1] + s[i]);
        }
        System.out.println(d[n]);
    }
}