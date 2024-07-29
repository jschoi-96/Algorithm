import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    /*
        1. 문자열의 길이가 짧은 순으로 정렬
        2. 길이가 같다면 사전순으로 정렬
        3. 백준 링크를 맨 마지막에 작성
        4. 문제 번호가 작은 순서대로 정렬
     */
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.startsWith("boj.kr")) {
                arr2.add(input);
            }
            else {
                arr1.add(input);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(arr1, (a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        for (String s : arr1) {
            sb.append(s).append("\n");
        }

        Collections.sort(arr2, (a,b) -> {
            String [] str1 = a.split("/");
            String [] str2 = b.split("/");
            int num1 = Integer.parseInt(str1[1]);
            int num2 = Integer.parseInt(str2[1]);
            return num1 - num2;
        });

        for (String s : arr2) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
