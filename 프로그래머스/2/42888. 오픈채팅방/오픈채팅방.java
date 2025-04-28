import java.util.*;
class Solution {
    public String[] solution(String[] record) {
    
        
        Map<String, String> map = new HashMap<>();
        
        for(String re : record) {
            String [] arr = re.split(" ");
            if (arr.length == 3) {
                map.put(arr[1], arr[2]);
            }
        }
        
        // 다시 record를 순회하며 Enter, Leave 여부를 체크
        List<String> res = new ArrayList<>();
        for(String re : record) {
            String [] arr = re.split(" ");
            String command = arr[0];
            
            String key = map.get(arr[1]);
            if (command.equals("Enter")) {
                res.add(key + "님이 들어왔습니다.");
            }
            
            else if (command.equals("Leave")) {
                res.add(key + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}