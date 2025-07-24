import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] s = input.split(" ");
        String A = s[0];
        String B = s[1];

        // 최소 차이를 저장할 변수, 최대 가능한 차이로 초기화 (A의 길이)
        int minDiff = A.length(); 

        // B의 모든 부분 문자열을 순회
        // B의 시작 인덱스 i부터, A의 길이만큼의 부분 문자열을 추출
        for (int i = 0; i <= B.length() - A.length(); i++) {
            int currentDiff = 0; // 현재 부분 문자열과 A의 차이
            // A와 B의 현재 부분 문자열을 비교
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) { // A의 j번째 문자와 B의 (i+j)번째 문자 비교
                    currentDiff++;
                }
            }
            // 현재까지의 최소 차이와 비교하여 업데이트
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }
        System.out.println(minDiff);
    }
}