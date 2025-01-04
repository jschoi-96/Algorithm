class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet<>();

        int ans = 0;

        // 1. 고유한 문자를 저장
        for (char c : s.toCharArray()) set.add(c);

        for (char c : set) {

            // 2. 문자의 처음 등장 인덱스와 마지막 인덱스를 정의
            int i = -1;
            int j = 0;

            for(int k = 0; k < s.length(); k++) {

                // 3. 고유한 문자가 s의 문자와 일치하는 경우, 인덱스 값들을 갱신
                if (c == s.charAt(k)) {

                    if (i == -1) {
                        i = k;
                    }
                    j = k;
                }
            }

            Set<Character> between = new HashSet<>();

            // 4. 해당 문자의 첫번째와 마지막 인덱스 사이에 있는 모든 문자를 저장한다,
            for(int k = i + 1; k < j; k++) {
                between.add(s.charAt(k));
            }

            // 5. 저장한 사이즈만큼 결과값에 더해준다
            ans += between.size();
        }
        return ans;
    }
}