import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            Stack<Character> s = new Stack();
            for (char c : input.toCharArray()) {

                if (!s.isEmpty() && s.peek() == c) {
                    s.pop();
                }

                else s.add(c);
            }

            if (s.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}
