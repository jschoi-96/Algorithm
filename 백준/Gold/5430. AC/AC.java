import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) { // t = 100
            String p = br.readLine(); // 100000
            int n = Integer.parseInt(br.readLine()); // 100000
            String s = br.readLine();

            s = s.substring(1, s.length()-1);
            String[] split = s.split(",");
            Deque<Integer> dq = new ArrayDeque<>();
            boolean front = true; // true인 경우 앞에서 빼고, 아닌 경우엔 뒤에서
            boolean error = false;
            if (n != 0) {
                for(int i = 0; i < split.length; i++) {
                    dq.addLast(Integer.parseInt(split[i]));
                }
            }



            for(char c : p.toCharArray()) {
                if (c == 'R') front = !front;
                else {
                    if (dq.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }

                    if (front) dq.pollFirst();
                    else dq.pollLast();
                }
            }

            if (error) continue;


            if (n == 0 && p.charAt(0) == 'R') {
                sb.append("[]\n");
            }
            else {
                if (dq.isEmpty()) sb.append("[]\n");
                else {
                    sb.append("[");
                    while(!dq.isEmpty()) {
                        if (front) sb.append(dq.pollFirst() + ",");
                        else sb.append(dq.pollLast() + ",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("]\n");
                }
            }
        }
        System.out.println(sb);
    }
}
