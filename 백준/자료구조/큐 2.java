
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) queue.add(Integer.parseInt(st.nextToken()));

            else if (s.equals("pop")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else if (s.equals("size")) sb.append(queue.size()).append("\n");
            else if (s.equals("empty")) {
                if (queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if (s.equals("front")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            }
            else if (s.equals("back")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
