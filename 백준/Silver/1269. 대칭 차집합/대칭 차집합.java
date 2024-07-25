import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        int a_size = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            a_size++;
        }

        int dup = 0;
        int b_size = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                dup++;
            }
            b_size++;
        }
        // System.out.println(a_size + " " + dup + " " + b_size);
        System.out.println(a_size - dup + b_size - dup);
    }
}