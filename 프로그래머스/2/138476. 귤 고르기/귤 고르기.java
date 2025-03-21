import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 1 2 2 3 3 4 5 5
        List<Integer> count = new ArrayList<>(map.values());
        Collections.sort(count, Collections.reverseOrder());
        
        int total = 0;
        for(int i = 0; i < count.size(); i++) {
            int tan_cnt = count.get(i);
            total += tan_cnt;
            answer++;
            if (total >= k) {
                return answer;
            }
        }
        return answer;
    }
}