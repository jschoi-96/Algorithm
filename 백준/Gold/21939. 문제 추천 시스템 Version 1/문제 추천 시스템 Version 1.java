import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Node> min_pq = new PriorityQueue<>((a, b) -> {
            if (a.diff == b.diff) return a.num - b.num;
            return a.diff - b.diff;
        });

        PriorityQueue<Node> max_pq = new PriorityQueue<>((a, b) -> {
            if (a.diff == b.diff) return b.num - a.num;
            return b.diff - a.diff;
        });

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 문저번호
            int q = Integer.parseInt(st.nextToken()); // 난이도
            map.put(p, q);
            max_pq.add(new Node(p, q));
            min_pq.add(new Node(p, q));
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            String[] arr = input.split(" ");

            if (arr[0].equals("add")) {
                Integer p = Integer.parseInt(arr[1]);
                Integer q = Integer.parseInt(arr[2]);
                map.put(p, q);
                max_pq.add(new Node(p, q));
                min_pq.add(new Node(p, q));
            }

            else if (arr[0].equals("solved")) {
                map.remove(Integer.parseInt(arr[1]));
            }

            else { // recommend
                int x = Integer.parseInt(arr[1]);
                if (x == 1) {
                    while(!max_pq.isEmpty()) {
                        Node cur = max_pq.peek();
                        if (map.containsKey(cur.num) && map.get(cur.num) == cur.diff) {
                            sb.append(max_pq.peek().num).append("\n");
                            break;
                        }
                        max_pq.poll();
                    }
                }

                else {
                    while (!min_pq.isEmpty()) {
                        Node cur = min_pq.peek();
                        if (map.containsKey(cur.num) && map.get(cur.num) == cur.diff) {
                            sb.append(min_pq.peek().num).append("\n");
                            break;
                        }
                        min_pq.poll();
                    }
                }
            }
        }
        System.out.println(sb);
    }

    public static class Node {
        int num;
        int diff;
        public Node(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }
    }
}
