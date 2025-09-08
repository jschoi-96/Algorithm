import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int sum = 0;

        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < w; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++;
            sum -= bridge.poll();

            if (!truck.isEmpty()) {
                if (truck.peek() + sum <= l) {
                    sum += truck.peek();
                    bridge.add(truck.poll());
                }

                else bridge.add(0);
            }
        }

        System.out.println(time);
    }
}
