import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 10만 , 제한시간 2초

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            pq.add(size);
        }

        int answer = 0;
        // 1. 우선순위 큐에서 가장 우선 순위가 낮은 두 값을 찾아서 더하고 큐에서 빼준다.
        // 2. 두 값의 합을 answer에 더해주고, 우선순위 큐에 합을 넣는다.
        // 3. 1을 다시 진행한다.
        while(!pq.isEmpty()) {
            if (pq.size() < 2) break;
            int num1 = pq.poll();
            int num2 = pq.poll();
            int sum = num1 + num2;
            pq.add(sum);
            //System.out.println(num1);
            //System.out.println(num2);
            answer += sum;

        }
        System.out.println(answer);
    }
}