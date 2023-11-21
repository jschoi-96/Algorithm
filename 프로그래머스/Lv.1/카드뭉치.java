import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int idx1 = 0;
        int idx2 = 0;
        
        // goal 배열을 순회하면서 일치하는 카드가 있을 때, index를 업데이트 해준다
        for(String target : goal) {
            if (idx1 < cards1.length && target.equals(cards1[idx1])){
                idx1++;
            }
            
            else if (idx2 < cards2.length && target.equals(cards2[idx2])) {
                idx2++;
            }
            else return "No";
        }
        return "Yes";
    }
}
