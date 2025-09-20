import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            parent = new int[n+1];
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }

            sb.append("Scenario " + cnt + ":" + "\n");
            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (find(a) != find(b)) sb.append(0).append("\n");
                else sb.append(1).append("\n");
            }
            sb.append("\n");
            cnt++;
        }
        System.out.println(sb);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a != b) parent[b] = a;
    }

    public static int find(int k) {
        if (parent[k] != k) {
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }
}