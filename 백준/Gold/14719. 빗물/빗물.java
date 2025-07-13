import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int h, w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[w];
        for(int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for(int i = 1; i < w - 1; i++) {
            int cur = arr[i];
            int l = 0, r = 0;
            for(int j = 0; j < i; j++) l = Math.max(l, arr[j]);
            for(int j = i + 1; j < w; j++) r = Math.max(r, arr[j]);

            if (l > cur && r > cur) res += Math.min(l, r) - cur;
        }
        System.out.println(res);
    }
}
