import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> s = new Stack<>();
        long cnt = 0;
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            cnt += s.size();
            s.add(arr[i]);
        }

        System.out.println(cnt);
    }
}
