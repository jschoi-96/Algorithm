import java.util.*;
class Solution {
    
    static String [] vowel = {"A","E","I","O","U"};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        recursion(word, "", 0);
        
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private void recursion(String word, String str, int depth) {
        list.add(str);
        
        if (depth == 5) {
            return;
        }
        
        for(String s : vowel) {
            recursion(word, str + s, depth + 1);
        }
    }
}