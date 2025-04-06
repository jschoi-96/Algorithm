import java.util.*;
class Solution {
    /*
        0 -> 알아볼수 없는 문제
        해당 값을 바꾸면서 최저, 최고순위를 찾음
        1. HashSet에 win_nums를 저장
        2. lottos를 순회하며 set이 해당 번호를 contains하는지 추적
        3. 이 때, 0의 갯수도 같이 추적함.
        4. 일치하는 번호의 개수는 최소: contains개수, 최대: contains개수 + 0의 개수
        5. 순위 계산은 6 - 일치 갯수 + 1
    */
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int n = lottos.length; // 로또와 win 모두 길이 동일
        
        HashSet<Integer> set = new HashSet<>();
        for(int win : win_nums) set.add(win);
        
        int has = 0; // 일치 개수
        int zero = 0; // 0의 개수
        for(int lotto : lottos) {
            if (set.contains(lotto)) has++;
            else if (lotto == 0) zero++;
        }
        
        int lo = has;
        int hi = has + zero;
        
        // 맞춘 갯수가 0개라면 1로 엣지처리 
        if (lo == 0) lo = 1;
        if (hi == 0) hi = 1;
        answer[1] = 6 - lo + 1;
        answer[0] = 6 - hi + 1;
        return answer;
    }
}