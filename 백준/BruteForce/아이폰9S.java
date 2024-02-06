package 백준.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
풀이 방법
같은 용량을 원하는 사람들을 일괄적으로 빼주기 위해서 HashSet을 사용하였다.

문제에서 O(N^2)로 풀었는데, n의 값이 1000 이므로 풀이가 가능하다.

array를 돌면서,
1. 빼주는 값과 일치하다면 카운트 하지 않으므로 continue해서 넘겨준다.
2. prev라는 값은 현재 보고있는 인덱스보다 1 작은 값으로, 연속된 값을 파악하기 위해 만듬
    - 현재 보고있는 값이 prev와 같다면, 연속된 숫자이므로 구간 길이 + 1
    - 현재 보고 있는 값이 prev와 다르다면, 연속된 숫자가 아니므로 길이 초기화
 */
public class 아이폰9S {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> eraseSet = new HashSet<>();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int vol = Integer.parseInt(br.readLine());
            eraseSet.add(vol);
            arr[i] = vol;
        }

        int max_len = 1;
        for(Integer erase : eraseSet) {
            int len = 1;
            int prev = -1; // 이전 값
            for(int i = 1; i < n; i++) {
                if (arr[i] == erase) continue; // 지울 값이라면 continue

                if (arr[i] == prev) {
                    len++;
                    max_len = Integer.max(max_len, len);
                }

                else {
                    len = 1;
                }
                prev = arr[i];
            }
        }
        System.out.println(max_len);
    }
}
