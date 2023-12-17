import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            dq.add(i);
        }

        while(dq.size() > 1) {
            dq.removeFirst();
            dq.addLast(dq.peek());
            dq.pollFirst();
        }
        System.out.println(dq.peek());
    }
}

// 풀이방법
// 1. 카드를 제일 위랑 제일 밑에 접근하는 문제 방식 때문에 자료구조 덱을 떠올렸다.
// 2. 맨위를 제거하고, 그 다음에 peek() 원소를 맨 밑으로 내리고 제거하는 방식
