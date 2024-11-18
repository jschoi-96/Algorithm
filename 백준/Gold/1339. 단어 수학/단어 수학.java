import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static int n;
    static int [] arr;
    static List<Character> list = new ArrayList<>();
    static boolean [] visited = new boolean[10];
    static String [] words;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = br.readLine();
            for(int j = 0; j < words[i].length(); j++) {
                if (!list.contains(words[i].charAt(j))) list.add(words[i].charAt(j));
            }
        }

        arr = new int[list.size()];

        dfs(0);
        System.out.println(max);
    }

    // GCF + ACDEB
    // A 2C

    public static void dfs(int depth) {
        if (depth == list.size()) {
            max = Math.max(max, calculate());
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                arr[depth] = 0;
                visited[i] = false;
            }
        }
    }

    public static int calculate() {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            map.put(list.get(i), arr[i]); //
        }

        int sum = 0;
        for(String word : words) {
            int num = 0;
            for(char c : word.toCharArray()) {
                num = num * 10 + map.get(c);
            }
            sum += num;
        }
        return sum;
    }
}
