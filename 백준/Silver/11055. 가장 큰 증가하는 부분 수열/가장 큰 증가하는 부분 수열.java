import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i]: i번째 원소를 방문할 때 증가하는 부분 수열의 최댓값
    점화식: d[i] = max(d[i], d[j] + s[i])
 */
public class Main {
    static int n;
    static int [] s, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d = new int[n];
        s = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            d[i] = s[i];
        }

        int max = d[0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (s[i] > s[j]) {
                    d[i] = Math.max(d[i], s[i] + d[j]);
                }
            }
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }
}