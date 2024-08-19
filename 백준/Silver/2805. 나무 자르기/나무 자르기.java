import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long lo = 0; long hi = trees[n-1];
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long res = 0;
            for(int tree : trees) {
                if (tree > mid) res += (tree - mid);
            }

            if (res < m) {
                hi = mid - 1;
            }

            else { // res가 m보다 크다면 하한점을 높여줘서 res값을 줄여줘야 한다.
                lo = mid + 1;
            }
        }
        System.out.println(lo - 1);
    }
}
