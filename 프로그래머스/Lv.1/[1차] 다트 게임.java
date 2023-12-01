import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        // 3번의 기회가 주어짐
        // S, D, T 영억이 존재
        // *(전의 점수 두배) , #(점수 마이너스)
        // 
        
        // S,D,T로 substring을 해야하나?
        HashMap<Integer, Integer> score = new HashMap<>();
        int count = 0;
        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            if (Character.isDigit(c)) {
                if (i > 0 && Character.isDigit(dartResult.charAt(i-1))) {
                    String num = dartResult.substring(i-1,i+1);
                    score.put(count - 1, Integer.parseInt(num));
                }
                
                else score.put(count++, Integer.parseInt(String.valueOf(c)));
            }
            
         
            else if (c == 'S') score.put(count - 1, score.get(count - 1));
            else if (c == 'D') score.put(count - 1, (int) Math.pow(score.get(count - 1), 2));
            else if (c == 'T') score.put(count - 1, (int) Math.pow(score.get(count - 1), 3));
            
            else if (c == '*') { // 해당점수와 그전의 점수 * 2;
                if (count == 1) {
                    int update = score.get(0);
                    score.put(count - 1, update *= 2);
                }
                
                else {
                    int first = score.get(count - 2);
                    int second = score.get(count - 1);
                    score.put(count - 2, first *= 2);
                    score.put(count - 1, second *= 2);
                }
            }
            
            else if (c == '#') {
                // count - 1을 마이너스로 바꿈
                int update = score.get(count - 1);
                score.put(count - 1, update *= -1);
            }
        }
        
        for(Integer val : score.keySet()){
            System.out.println(score.get(val));
            answer += score.get(val);
        }
        return answer;
    }
}
