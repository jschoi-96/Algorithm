import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 1 2 3 4 5 6 7
        sb.append("<");
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {

            for(int i = 0; i < k - 1; i++) {
                int val = queue.poll();
                queue.add(val);
            }
            if (queue.size() == 1) sb.append(queue.poll());
            else sb.append(queue.poll()).append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
