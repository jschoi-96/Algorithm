import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] minus = input.split("-");

        List<Integer> list = new ArrayList<>();
        for(String m : minus) {
            String[] plus = m.split("[+]");
            if (plus.length == 1) list.add(Integer.parseInt(plus[0]));
            else {
                int sum = 0;
                for(int i = 0; i < plus.length; i++) {
                    sum += Integer.parseInt(plus[i]);
                }
                list.add(sum);
            }
        }

        int res = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            res -= list.get(i);
        }
        System.out.println(res);
        // 10+20-30+40-50
    }
}