import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        dfs(0, 0, 0, input.contains("L"), input, 1);
        System.out.println(res);
    }

    public static void dfs(int idx, int vowelCount, int otherCount, boolean hasL, String input, long cnt) {
        if (vowelCount == 3 || otherCount == 3) {
            return;
        }

        if (idx == input.length()) {
            if (hasL) res += cnt;
            return;
        }

        char c = input.charAt(idx);

        if (c == '_') {
            dfs(idx + 1, vowelCount + 1, 0, hasL, input, cnt * 5); // 모음
            dfs(idx + 1, 0, otherCount + 1, hasL, input, cnt * 20);
            dfs(idx + 1, 0, otherCount + 1, true, input, cnt);
        }

        else {
            if (isVowel(c)) dfs(idx + 1, vowelCount + 1, 0, hasL, input, cnt);
            else dfs(idx + 1, 0, otherCount + 1, hasL, input, cnt);
        }
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
