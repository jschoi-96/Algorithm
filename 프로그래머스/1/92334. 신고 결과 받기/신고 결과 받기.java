import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 1. 해쉬맵을 선언하여 신고한 사람들을 저장. 해쉬맵을 통해 중복을 방지
        
        // 초기화
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> track = new HashMap<>();
        
        for(String id : id_list) {
            map.put(id, new HashSet<>());
            track.put(id, 0);
        }
        
        for(String re : report) {
            String [] str = re.split(" ");
            Set<String> reporters = map.get(str[0]);
            reporters.add(str[1]);
            map.put(str[0], reporters);
        }
        
        // 2. 맵을 선언하여 각 신고당한 사람들의 등장횟수를 저장
        Map<String, Integer> cntMap = new HashMap<>();        
        for(String key : map.keySet()) {
            Set<String> set = map.get(key);
            for(String s :set) {
                cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
            }
        }
        
        // 3. 다시 맵을 돌며 등장횟수와 k를 비교한다.
        for(String key : map.keySet()) {
            Set<String> set = map.get(key);
            int cnt = 0;
            for(String s : set) {
                if (cntMap.get(s) >= k) {
                    cnt++;
                }
            }
            // System.out.println(key + " " + map.get(key));
            // id_list에 해당하는 key에 최종 신고횟수를 저장함
            track.put(key, cnt);
        }
        
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = track.get(id_list[i]);
        }
        return answer;
    }
}