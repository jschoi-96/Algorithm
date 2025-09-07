import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!s.isEmpty() && s.peek() > y) { // 높이가 낮아짐 -> pop
                res++;
                s.pop();
            }

            if (!s.isEmpty() && s.peek() == y) continue;
            s.push(y);
        }

        while (!s.isEmpty() && s.peek() > 0) {
            res++;
            s.pop();
        }

        System.out.println(res);
    }
}
