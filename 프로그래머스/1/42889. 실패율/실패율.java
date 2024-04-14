import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // 1. stages를 순회하며 해당 숫자의 등장 횟수를 저장함
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= N; i++){
            map.put(i, 0);
        }
        
        for(Integer stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }
        
        // 2. 실패율을 담는 배열을 구현
        int total = stages.length;
        Map<Integer, Double> fails = new HashMap<>();
        for(int i = 0; i < N; i++){
            if (total == 0) {
                fails.put(i+1, 0.0);
                continue;
            }
            fails.put(i+1, (double) map.get(i+1) / total);
            total -= map.get(i+1);
        }
        
        // 3. values를 기준으로 내림차순하기!!!
        List<Map.Entry<Integer, Double>> entries = new LinkedList<>(fails.entrySet());
        entries.sort((v1,v2) -> v2.getValue().compareTo(v1.getValue()));
        
        int idx = 0;
        for(Map.Entry<Integer,Double> entry : entries) {
            answer[idx++] = entry.getKey();
        }
        return answer;
    }
}