import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack s1 = new Stack();
        for(char c : s.toCharArray()) s1.push(c);

        Stack s2 = new Stack();

        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            String[] str = input.split(" ");

            if (str.length == 2) {
                s1.add(str[1]);
            }

            else {
                if (str[0].equals("L")) {
                    if (!s1.isEmpty()) s2.add(s1.pop());
                }

                else if (str[0].equals("D")) {
                    if (!s2.isEmpty()) s1.add(s2.pop());
                }

                else if (str[0].equals("B")) {
                    if (!s1.isEmpty()) s1.pop();
                }
            }
        }

        while(!s1.isEmpty()) s2.add(s1.pop());

        StringBuilder sb = new StringBuilder();
        while(!s2.isEmpty()) sb.append(s2.pop());

        System.out.println(sb);
    }
}
