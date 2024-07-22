import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            map1.put(input, i);
            map2.put(i, input);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                sb.append(map2.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(map1.get(input)).append("\n");
            }
        }

        System.out.println(sb);

    }
}