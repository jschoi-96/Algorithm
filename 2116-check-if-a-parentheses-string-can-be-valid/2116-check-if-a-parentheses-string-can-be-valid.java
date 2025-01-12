class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int balance = 0;
        // 왼쪽에서 오른쪽: ')'가 너무 많지 않은지 확인
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) return false;
        }

        balance = 0;
        // 오른쪽에서 왼쪽: '('가 너무 많지 않은지 확인
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) return false;
        }

        return true;
    }
}