import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        // stages[i]가 i 값이라면, stage i에서 멈춰있다는 뜻
        // stages 20만 -> 시간복잡도 고려
        
        // 실패율을 double로 저장하는 배열을 만듬
        
        Arrays.sort(stages); 
        
        //Double [] temp = new Double[N];
        Map<Integer, Double> map = new HashMap<>();
        int len = stages.length;
        int idx = 0;
        
        for(int i = 1; i <= N; i++){
            
            int total = len - idx; // 스테이지가 올라갈 수록 총 사용자 수 감소
            int each = 0;
            for(int j = 0; j < len; j++){
                if (stages[j] == i){
                    idx++;
                    each++;
                }
            }
            
            if (total == 0) map.put(i, 0.0); // 마지막 스테이지 도전자가 0명일 때
            else map.put(i , (double) each / total);
        }
        
        List<Map.Entry<Integer,Double>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        int index = 0;
        
        for(Map.Entry<Integer,Double> entry : entryList){
            answer[index++] = entry.getKey();
        }
        return answer;
    }
}
