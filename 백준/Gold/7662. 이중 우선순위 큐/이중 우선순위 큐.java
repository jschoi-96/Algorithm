import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int t;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(num , map.getOrDefault(num, 0) + 1);
                }

                else if (command.equals("D")) {
                    if (!map.isEmpty() && num == 1) { // 최댓값 삭제
                        num = map.lastKey();
                    }

                    else if (!map.isEmpty() &&  num == -1) {
                        num = map.firstKey();
                    }

                    if (!map.isEmpty() && map.put(num, map.get(num) - 1) == 1) { // map에서 num의 value를 1 줄였을 때, 해당 값이 1이라면 해당 key를 삭제한다.
                        map.remove(num);
                    }
                }
            }
            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
