import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

//        for(int i = 1; i <= n; i++) {
//            System.out.print(parent[i] + " ");
//        }
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) { //
                    union(i, j);
                }
            }
        }

//        System.out.println();
//        for(int i = 1; i <= n; i++) {
//            System.out.print(parent[i] + " ");
//        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for(int i = 1; i < m; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(start) != find(next)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int i, int j) {
        i = find(i);
        j = find(j);
        if (i != j) {
            parent[j] = i;
        }
    }

    public static int find(int num) {
        if (num == parent[num]) {
            return num;
        }
        return parent[num] = find(parent[num]);
    }
}
