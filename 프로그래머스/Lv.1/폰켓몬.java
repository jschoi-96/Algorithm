import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // n/2개를 선택 가능, 최대한 많은 종류의 폰켓몬
        HashSet<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            if (set.size() < nums.length / 2)
                set.add(num);
        }
        
        for(int i = 0; i < set.size(); i++){
            answer++;
        }
        return answer;
    }
}
