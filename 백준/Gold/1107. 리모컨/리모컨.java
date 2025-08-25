import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] possible = new boolean[10];
        for (int i = 0; i < 10; i++) possible[i] = true;

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                possible[Integer.parseInt(st.nextToken())] = false;
            }   
        }

        int target = Math.abs(n - 100); // 100에서 시작하기 때문에 빼준다.

        for(int i = 0; i <= 1000000; i++) {
            String s = String.valueOf(i);

            boolean flag = false;
            for(int j = 0; j < s.length(); j++) {
                if (!possible[s.charAt(j) - '0']) { // 누를 수 없는 버튼인 경우 중단
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                // +,-로 도달하는 횟수 + 숫자버튼 누른 횟수
                int min = Math.abs(n - i) + s.length();
                target = Math.min(target, min);
            }
        }
        System.out.println(target);
    }
}
