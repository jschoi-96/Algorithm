import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int [] a = new int[n];
        int [] b = new int[m];

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            set.add(a[i]);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (set.contains(b[i])) {
                set.remove(b[i]);
            }
        }

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);
        if (list.size() == 0) {
            System.out.println(0);
        }

        else {
            System.out.println(list.size());
            for (int num : list) {
                System.out.print(num + " ");
            }
        }
    }
}
