import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] s = input.split(" ");
            map.put(s[0], s[1]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            sb.append(map.get(input)).append("\n");
        }
        System.out.println(sb);
    }
}
