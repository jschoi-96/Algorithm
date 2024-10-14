import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int [] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3, 5, 2, 7

        // 스택에 숫자를 넣는게 아니라 인덱스를 넣는다>??
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && arr[s.peek()] < arr[i]) { // arr[0] = 3,
                arr[s.pop()] = arr[i];
            }

            s.add(i); // 스택에 숫자를 넣어준다
        }

        while (!s.isEmpty()) {
            arr[s.pop()] = -1;
        }

        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}