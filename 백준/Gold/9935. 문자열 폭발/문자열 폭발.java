import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String boom = br.readLine();

        Stack<Character> s = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            s.add(c);

            if (s.size() >= boom.length()) {
                boolean match = true;
                for(int j = 0; j < boom.length(); j++) {
                    if (s.get(s.size() - boom.length() + j) != boom.charAt(j)) {
                        match = false;
                        break;
                    }
                }


                if (match) {
                    for (int j = 0; j < boom.length(); j++) {
                        s.pop();
                    }
                }
            }
        }

        if (s.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while(!s.isEmpty()) {
                sb.append(s.pop());
            }
            System.out.println(sb.reverse());
        }
    }
}
