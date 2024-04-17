class Solution {
    boolean solution(String s) {
        boolean answer = true;

        if (!s.contains("p") && !s.contains("y")) {
            return true;
        }
        
        int pCount = 0;
        int yCount = 0;
        for(char c : s.toCharArray()) {
            c = Character.toLowerCase(c);
            if (c == 'p') pCount++;
            else if (c == 'y') yCount++;
        }

        return pCount == yCount;
    }
}