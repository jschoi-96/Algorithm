import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
        1. 여행 계획 처음부터 BFS를 돌리면서 체크
     */
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean [] visited = new boolean[202];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) graph.get(i).add(j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> paths = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int start = Integer.parseInt(st.nextToken());
            paths.add(start);
        }

        for(int i = 0; i < paths.size() - 1; i++) {
            visited = new boolean[202];
            //System.out.println(paths.get(i) + " " + paths.get(i + 1));
            if (!dfs(paths.get(i), paths.get(i+1))) { // dfs를 돌리면서 다음 지점에 도달할 수 있는지 확인한다.
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    public static boolean dfs(int start, int destination) {
        if (start == destination) {
            return true;
        }

        visited[start] = true;

        for(int nxt : graph.get(start)) {
            if(!visited[nxt] && dfs(nxt, destination)) {
                return true;
            }
        }
        return false;
    }

}
