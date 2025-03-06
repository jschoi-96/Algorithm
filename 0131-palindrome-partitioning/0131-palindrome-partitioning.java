class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    public void dfs(String s, int idx, List<String> tmp) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (isValid(str)) {
                tmp.add(str);
                System.out.println(str);
                dfs(s, i + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isValid(String str) {
        int lo = 0, hi = str.length() - 1;
        while(lo < hi) {
            if (str.charAt(lo) != str.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
}