import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();
        
        String [] today_total = today.split("\\.");
        int year = Integer.parseInt(today_total[0]) * 12 * 28;
        int month = Integer.parseInt(today_total[1]) * 28;
        int day = Integer.parseInt(today_total[2]);
        int sum = year + month + day;
        
        int index = 1;
        Map<String, Integer> termsMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String [] split_terms = terms[i].split("\\ ");
            termsMap.put(split_terms[0], Integer.parseInt(split_terms[1]));
        }
        
        for(String privacy : privacies) {
            String [] privacy_list = privacy.split("\\.");
            int pri_year = Integer.parseInt(privacy_list[0]) * 12 * 28;
            int pri_month = Integer.parseInt(privacy_list[1]) * 28;
            
            String [] daysAndPlayer = privacy_list[2].split("\\ ");
            int pri_day = Integer.parseInt(daysAndPlayer[0]);
            
            String player = daysAndPlayer[1];
            int pri_sum = pri_year + pri_month + pri_day;
            
            int range = termsMap.get(player); // 해당 알파벳에 대한 유효기간 값
            
            if (sum - pri_sum >= range * 28) { // 현재 날짜에서 수집일자를 뺀 값이 유효기간을 초과했을 때 -> 파기
                answer.add(index);
            }
            index++;
        }
        
        int [] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
        //return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
