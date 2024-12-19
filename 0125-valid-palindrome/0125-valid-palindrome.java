class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            while(!isPalin(s.charAt(i)) && i < j) i++;
            while(!isPalin(s.charAt(j)) && j > i) j--;

            char st = s.charAt(i);
            char en = s.charAt(j);
            st = Character.toLowerCase(st);
            en = Character.toLowerCase(en);

            if (st != en) return false;
            i++; j--;
        }
        return true;
    }

    public boolean isPalin(Character c) {
        if (c >= '0' && c <= '9' || Character.isAlphabetic(c)) return true;
        return false;
    }
}