import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) ops.add(input.charAt(i));
            else nums.add(input.charAt(i) - '0');
        }
        dfs(0, nums.get(0));
        System.out.println(max);
    }

    public static void dfs(int idx, int cur) {
        if (idx >= ops.size()) { // 연산자 갯수만큼 순회
            max = Math.max(max, cur);
            return;
        }

        int res1 = cal(cur, ops.get(idx), nums.get(idx + 1));
        dfs(idx + 1, res1);

        if (idx + 1 < ops.size()) {
            int tmp = cal(nums.get(idx + 1), ops.get(idx + 1), nums.get(idx + 2));
            int res2 = cal(cur, ops.get(idx), tmp);
            dfs(idx + 2, res2);
        }
    }

    public static int cal(int n1, char op, int n2) {
        if (op == '+') return n1 + n2;
        if (op == '-') return n1 - n2;
        if (op == '*') return n1 * n2;
        return 0;
    }
}
