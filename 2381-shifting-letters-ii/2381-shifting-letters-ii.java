class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int [] prefix = new int[n + 1];

        for(int [] shift : shifts) {
            int st = shift[0];
            int en = shift[1];
            int dir = shift[2];

            if (dir == 1) {
                prefix[st]++;
                prefix[en+1]--;
            }

            else {
                prefix[st]--;
                prefix[en+1]++;
            }
        }
        
        int [] sum = new int[n];
        int cur = 0;
        for(int i = 0; i < n; i++) {
            cur += prefix[i];
            sum[i] = cur;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int shift = ((sum[i] % 26) + 26) % 26;
            char c = (char) ('a' + (s.charAt(i) - 'a' + shift) % 26);
            sb.append(c);
        }
        return sb.toString();
    }
}