import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            while (n-- > 0) {
                String input = br.readLine();
                String[] arr = input.split(" ");
                map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            }

            if (map.size() == 1) {
                for (String key : map.keySet()) {
                    sb.append(map.get(key)).append("\n");
                }
            }
            else {
                int res = 1;
                for (String key : map.keySet()) {
                    res *= (map.get(key) + 1);
                }
                res -= 1;
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }
}