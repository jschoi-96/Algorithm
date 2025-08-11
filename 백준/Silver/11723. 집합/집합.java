import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String input = br.readLine();
            String[] split = input.split(" ");

            String command = split[0];
            int n = 0;
            if (split.length == 2) n = Integer.parseInt(split[1]);

            if (command.equals("add")) {
                if (!set.contains(n)) {
                    set.add(n);
                }
            }

            else if (command.equals("remove")) {
                if (set.contains(n)) {
                    set.remove((Integer) n);
                }
            }

            else if (command.equals("check")) {
                if (set.contains(n)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }

            else if (command.equals("toggle")) {
                if (set.contains(n)) set.remove(n);
                else set.add(n);
            }

            else if (command.equals("all")) {
                List<Integer> tmp = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                        16,17,18,19,20);
                set.addAll(tmp);
            }

            else if (command.equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}
