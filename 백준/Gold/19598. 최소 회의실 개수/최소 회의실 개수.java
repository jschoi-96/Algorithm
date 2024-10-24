import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int [][] arr = new int[n][2];

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료시간을 저장하는 큐
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            pq.add(b);
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        int cnt = 1;
        for(int i = 1; i < n; i++) {
            if (pq.peek() > arr[i][0]) { // 현재 종료시간이 다음 강의의 시작 시간보다 느리다면, 강의 증설
                cnt++;
            }
            else {
                pq.poll();
            }
        }
        System.out.println(cnt);
    }
}
