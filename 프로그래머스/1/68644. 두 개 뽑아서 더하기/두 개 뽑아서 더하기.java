import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}