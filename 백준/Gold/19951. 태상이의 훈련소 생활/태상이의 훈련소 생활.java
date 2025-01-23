import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] freq = new int[n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            freq[a-1] += k;
            if (b< n)
                freq[b] -= k;
        }

        for(int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
            //System.out.println(freq[i]);
        }

        StringBuilder s = new StringBuilder();
        for(int i = 0; i < n; i++) {
            arr[i] += freq[i];
            s.append(arr[i]).append(" ");
        }
        System.out.println(s);
    }
}
