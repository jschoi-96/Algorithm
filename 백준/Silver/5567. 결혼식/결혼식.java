import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<Integer> friends = graph.get(1); // 친구들
        // System.out.println(friends);

        if (friends.isEmpty()) {
            System.out.println(0);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int friend : friends) {
            set.add(friend);
            List<Integer> nexts = graph.get(friend);
            for(int next : nexts) set.add(next);
        }

        System.out.println(set.size() - 1);
    }
}