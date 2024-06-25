import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    테이블: d[i]: i명을 유치할 때 투자하는 돈의 최소값
    점화식: d[i]: Math.min(d[i],
 */
public class Main {
    static int c, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int size = c + 101;
        int [] d = new int[size];

        for(int i = 1; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        d[0] = 0;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for(int j = people; j < size; j++) {
                if (d[j - people] != Integer.MAX_VALUE)
                    d[j] = Math.min(d[j], d[j - people] + pay);
            }

        }

        int res = Integer.MAX_VALUE;
        for(int i = c; i < size; i++) {
            res = Math.min(res, d[i]);
        }
        System.out.println(res);
    }
}
