import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            list.add(input);
        }

        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            String reverse = new StringBuilder(word).reverse().toString();
            if (list.contains(reverse)) {
                int len = reverse.length();
                System.out.println(len + " " + reverse.charAt(len / 2));
                return;
            }
        }
    }
}
