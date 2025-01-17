class Solution {
    List<List<String>> res = new ArrayList<>();
    // 1. 문자열을 1, 2, 3... 씩 증가시켜가며 slice를 해준다.
    // 2. len이 문자열의 끝에 도달했을 때 리스트에 존재하는 문자열들이 팰린드롬인지 판단
    // 3. 팰린드롬이라면, res에 넣어주고 아니라면 continue. 
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }

        dfs(s, new ArrayList<>(), 0);
        return res;
    }

    public void dfs (String s, List<String> tmp, int idx) {

        if (idx == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
            if (isPalindrome(sub)) {
                tmp.add(sub);
                // System.out.println("idx: " + idx + " " + "i: " + i + " " + sub);
                dfs(s, tmp, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while(lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++; hi--;
        }
        return true;
    }
}