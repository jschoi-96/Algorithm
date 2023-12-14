import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!stack.isEmpty() && c == ')') {
                    if (stack.peek() == '(') stack.pop();
                }

                else stack.push(c);
            }

            if (stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
