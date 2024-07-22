import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        String input;
        int total = 0;
        while((input = br.readLine()) != null && !input.isEmpty()) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;
        }


        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);
        for (String s : list) {
            double res = (double) map.get(s) / total * 100;
            String portion = String.format("%.4f", res);
            System.out.println(s + " " + portion);
        }

    }
}