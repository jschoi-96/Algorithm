import java.util.*;
class Solution {
    // h의 최대값 -> 뒤에서 부터 탐색해야함 
    // 최초로 찾는 놈이 최대
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        // idx: 0 -> 1 -> 2..
        for(int i = citations.length; i >= 1; i--) {
            int idx = citations.length - i;
            if (citations[idx] >= i) {
                //System.out.println(citations[idx]);
                return i;
            }
        }
        // 0,1,3,5,6 
        // 6번 이상 인용 -> 1편
        // 5번 이상 인용 -> 2편
        // 3번 이상 인용 -> 3편 (최댓값)
        // 1번 이상 인용 -> 4편
        return answer;
    }
}