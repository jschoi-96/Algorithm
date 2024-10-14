import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 6 9 5 7 4
        // 왼쪽으로 레이저신호를 발사하고, 수신을 한 탑의 인덱스를 저장하고, 수신 못했을 경우 0
        Stack<int []> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int height = Integer.parseInt(st.nextToken());

            // 1. 스택이 비어있을 때
            // 2. 스택 값이 현재 높이보다 같거나 클 때
            // 3. 스택 값이 현재 높이보다 작을 때
            if (s.isEmpty()) {
                sb.append(0).append(" ");
            }
            else {
                if (s.peek()[0] >= height) {
                    sb.append(s.peek()[1]).append(" ");
                }
                // 6 9 5 7일때
                // 6 9 7 (5 pop)
                else {
                    while (!s.isEmpty()) {
                        if (s.peek()[0] >= height) {
                            sb.append(s.peek()[1]).append(" ");
                            break;
                        }
                        s.pop();
                    }
                    if (s.isEmpty()) sb.append(0).append(" ");
                }
            }
            s.push(new int[]{height, i});
        }
        System.out.println(sb);
    }

}