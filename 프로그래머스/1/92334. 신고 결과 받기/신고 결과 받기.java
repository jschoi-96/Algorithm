import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
       
        for(int i = 0; i < id_list.length; i++){
            reportMap.put(id_list[i], new HashSet<>());
            countMap.put(id_list[i], i);
        }
        
        for(String r : report) {
            String [] str = r.split(" ");
            String reporter = str[0];
            String reported = str[1];
            
            Set<String> set = reportMap.getOrDefault(reported, new HashSet<>());
            set.add(reporter);
            reportMap.put(reported, set);
        }
        
        for (int i = 0; i < id_list.length; i++){
            Set<String> names = reportMap.get(id_list[i]); 
            // 신고당한 사람들을 다시 set에 담는다.
            if (names.size() >= k) {
                for(String name : names){
                    answer[countMap.get(name)]++;
                }
            }
        }
        
        
        
        return answer;
    }
}