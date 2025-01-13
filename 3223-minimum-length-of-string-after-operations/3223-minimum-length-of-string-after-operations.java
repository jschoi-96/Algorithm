class Solution {
    public int minimumLength(String s) {

        if (s.length() < 3) return s.length();

        int [] occur = new int[26];

        List<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            occur[c - 'a']++;
            list.add(c);
        }

        for(int i = 1; i < s.length() - 1; i++) { // 첫번째, 마지막 인덱스는 제외
            char c = s.charAt(i);
            if (occur[c - 'a'] < 3) continue; // 등장횟수 3미만이면 제외.
            
            int l = 0, r = 0;

            boolean flag1 = false;
            boolean flag2 = false;
            for(int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == c) {
                    l = j;
                    flag1 = true;
                    break;
                }
            }

            for(int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    r = j;
                    flag2 = true;
                    break;
                }
            }

            if (flag1 && flag2) {
                s = s.substring(0,l) + s.substring(l+1,r) + s.substring(r+1,s.length());
                occur[c - 'a'] -= 2;
            }
        }   
        s = s.trim();
        return s.length();
    }
}