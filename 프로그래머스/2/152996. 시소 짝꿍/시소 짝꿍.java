import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        Map<Double, Integer> cntMap = new HashMap<>();
        
        // 1/2, 2/3, 3/4
        for(Integer weight : weights) {
            double a = weight * 1.0;
            double b = (weight * 1.0) / 2.0;
            double c = (weight * 3.0) / 4.0;
            double d = (weight * 2.0) / 3.0;
            if (cntMap.containsKey(a)) answer += cntMap.get(a);
            if (cntMap.containsKey(b)) answer += cntMap.get(b);
            if (cntMap.containsKey(c)) answer += cntMap.get(c);
            if (cntMap.containsKey(d)) answer += cntMap.get(d);
            cntMap.put(a, cntMap.getOrDefault(a, 0) + 1);
        }
        
        
        return answer;
    }
}