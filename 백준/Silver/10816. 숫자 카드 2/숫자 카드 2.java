import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static long [] card;
    static long [] card2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        card = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            card[i] = Integer.parseInt(st.nextToken());
            map.put(card[i], map.getOrDefault(card[i], 0) + 1);
        }

        m = Integer.parseInt(br.readLine());
        card2 = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            card2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (map.get(card2[i]) == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(map.get(card2[i])).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}