import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [] d = new int [1000002];
    static int[] path = new int[1000002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d[1] = 0;
        for(int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;
            path[i] = i-1;

            if (i % 2 == 0 && d[i] > d[i/2] + 1) { // d[i-1]과 d[i/2]비교해서 d[i/2]가 더 작다면 최솟값을 할당
                d[i] = d[i/2] + 1;
                path[i] = i/2;
            }

            if (i % 3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i / 3] + 1;
                path[i] = i/3;
            }
        }

        System.out.println(d[n]);

        int cur = n;
        while(true) {
            System.out.print(cur + " ");
            if (cur == 1) break;
            cur = path[cur];
        }
        System.out.println();
    }
}