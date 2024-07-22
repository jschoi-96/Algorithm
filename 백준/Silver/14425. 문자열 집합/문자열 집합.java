import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            list.add(input);
        }

        int res = 0;
        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            if (list.contains(input)) {
                res++;
            }
        }
        System.out.println(res);
    }
}