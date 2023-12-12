import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // [번호, 차례]
        
        char last_letter = words[0].charAt(words[0].length() - 1);
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        int count = 1; // 차례
        for(int i = 1; i < words.length; i++){
            String word = words[i];
            
            if (word.charAt(0) != last_letter || set.contains(word)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
            set.add(word);
            last_letter = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0,0};
    }
}
