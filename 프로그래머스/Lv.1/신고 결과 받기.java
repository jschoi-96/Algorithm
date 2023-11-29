import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reportMap = new HashMap<>();
        Map<String, HashSet<String>> result = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            reportMap.put(id_list[i], i);
            result.put(id_list[i] , new HashSet<>());
        }
        
        for (String info : report){
            String [] person = info.split(" ");
            String reporter = person[0];
            String reported = person[1];
            result.get(reported).add(reporter);
            
        }
        
        for (int i = 0; i < id_list.length; i++){
            HashSet<String> names = result.get(id_list[i]); 
            // 신고당한 사람들을 다시 set에 담는다.
            if (names.size() >= k) {
                for(String name : names){
                    answer[reportMap.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}
