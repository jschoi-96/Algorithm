import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int [] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        func(0);
        System.out.println(count);
    }

    public static void func(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            arr[depth] = i;
            if (possible(depth)) {
                func(depth + 1);
            }
        }
    }

    public static boolean possible(int depth) {
        for(int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) return false; // 같은 열에 위치하는지 y좌표 확인

            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) return false; // 열의 차와 행의 차가 같은 경우 -> 대각선
        }
        return true;
    }
}