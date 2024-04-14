import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int choose = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            set.add(num);
        }
        
        if (set.size() <= choose) answer = set.size();
        else answer = choose;
        return answer;
    }
}