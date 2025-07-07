import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<Integer> truthList = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> party = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());

        for(int i = 0; i < truthCnt; i++) {
            truthList.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < count; j++) {
                int p = Integer.parseInt(st.nextToken());
                tmp.add(p);
            }

            party.add(tmp);
            if (count > 1) {
                for(int j = 1; j < count; j++) {
                    int a = tmp.get(j-1);
                    int b = tmp.get(j);
                    graph.get(a).add(b);
                    graph.get(b).add(a);
                }
            }
        }

        for(int truth : truthList) {
            if (!visited[truth]) {
                dfs(truth);
            }
        }

        int res = 0;
        for(List<Integer> group : party) {
            boolean canLie = true;
            for(Integer p : group) {
                if (visited[p]) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) res++;
        }

        System.out.println(res);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for(int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
