import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        int len = nums.length / 2;
        
        if (set.size() > len) return len;
        else return set.size();
        
    }
}