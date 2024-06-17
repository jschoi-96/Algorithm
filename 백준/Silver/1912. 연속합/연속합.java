
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i]: i번째 숫자를 보고있을 때의 연속된 숫자들의 최댓값
    점화식: d[i] = max(d[i], d[i-1] + s[i])
 */
public class Main {
    static int n;
    static int [] s, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = s[0];
        int max = d[0];
        for(int i = 1; i < n; i++) {
            d[i] = Math.max(s[i], d[i - 1] + s[i]);
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}