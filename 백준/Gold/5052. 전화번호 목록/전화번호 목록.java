import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());

            boolean flag = false;
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            Collections.sort(list);

            for(int i = 0; i < list.size() - 1; i++) {
                String cur = list.get(i);
                String next = list.get(i+1);
                if (next.startsWith(cur)) {
                    flag = true;
                    break;
                }
            }

            if (flag) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}