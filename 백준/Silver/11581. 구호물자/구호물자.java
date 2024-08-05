import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int [] check;
    static boolean flag = false;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[n + 1];

        for(int i = 1; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph.get(i).add(a);
            }
        }

//        for(int i = 1; i <= n-1; i++){
//            System.out.println(graph.get(i));
//        }

        dfs(1);


        if (flag) System.out.println("CYCLE");
        else System.out.println("NO CYCLE");

        // -1: 방문 중인 교차로 (탐색 완료 X)
        // 0: 방문하지 않은 교차로
        // 1: 방문이 끝난 교차로 (탐색 O)
    }

    public static void dfs(int start) {

        // System.out.println("before: " + start + " " + check[start]);


        if (check[start] == -1) {
            flag = true;
            return;
        }

        check[start] = -1;

        //System.out.println("visit: " + start + " " + check[start]);


        for(int nxt : graph.get(start)) {
            if (check[nxt] != 1) {
                dfs(nxt);
            }
        }

        check[start] = 1;

        //System.out.println("after: " + start + " " + check[start]);

    }
}
