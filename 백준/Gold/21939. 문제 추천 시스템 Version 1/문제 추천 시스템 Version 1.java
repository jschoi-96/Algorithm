import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pos = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            };
            return b[1] - a[1];
        });

        Map<Integer, Integer> map = new HashMap<>(); // 추천 문제 리스트를 저장함

        PriorityQueue<int[]> neg = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            pos.add(new int[]{idx, diff});
            neg.add(new int[]{idx, diff});
            map.put(idx, diff);
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String input = br.readLine();

            String[] s = input.split(" ");
            if (s[0].equals("add")) {
                int idx = Integer.parseInt(s[1]);
                int diff = Integer.parseInt(s[2]);

                // if (list.contains(idx)) continue; //
                pos.add(new int[]{idx, diff});
                neg.add(new int[]{idx, diff});
                map.put(idx, diff);
            }

            else if (s[0].equals("solved")) {
                int idx = Integer.parseInt(s[1]);
                map.remove(idx);
            }

            else {
                int idx = Integer.parseInt(s[1]);
                if (idx == 1) {
                    while (true) {
                        // 맵에서
                        if (map.containsKey(pos.peek()[0]) && map.get(pos.peek()[0]) == pos.peek()[1]) {
                            sb.append(pos.peek()[0]).append("\n");
                            break;
                        }
                        pos.poll();
                    }
                }

                else {
                    while (true) {
                        if (map.containsKey(neg.peek()[0]) && map.get(neg.peek()[0]) == neg.peek()[1]) {
                            sb.append(neg.peek()[0]).append("\n");
                            break;
                        }
                        neg.poll();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
