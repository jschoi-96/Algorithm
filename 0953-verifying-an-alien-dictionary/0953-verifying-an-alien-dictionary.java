class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for(char o : order.toCharArray()) {
            map.put(o, idx++);
        }

        for(int i = 1; i < words.length; i++) {
            if (isValid(words[i], words[i-1], map)) return false;
        }

        return true;
    }

    public boolean isValid(String str1, String str2, Map<Character, Integer> map) {
        int len1 = str1.length();
        int len2 = str2.length();

        for(int i = 0; i < Math.min(len1, len2); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map.get(c1) > map.get(c2)) return false;
            else if (map.get(c1) < map.get(c2)) return true;
        }

        if (len1 <= len2) return true; // apple, app apple이 더 길기 때문에false
        return false;
    }
}