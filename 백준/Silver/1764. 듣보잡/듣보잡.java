import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> res = new ArrayList<>();
        int len = 0;
        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                len++;
                res.add(input);
            }
        }

        Collections.sort(res);

        System.out.println(len);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
