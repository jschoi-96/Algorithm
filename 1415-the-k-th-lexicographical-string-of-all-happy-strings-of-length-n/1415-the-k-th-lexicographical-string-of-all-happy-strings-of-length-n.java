class Solution {
    List<String> list = new ArrayList<>();
    public String getHappyString(int n, int k) {
        String res = "";
        dfs("", n);

        if (list.size() < k) return "";
        return list.get(k-1);
    }

    public void dfs(String cur, int n) {
        if (cur.length() == n) {
            // System.out.println(cur);
            list.add(cur);
            return;
        }

        for(char c : new char[]{'a', 'b', 'c'}) {
            if (cur.length() == 0)
                dfs(cur + c, n);
            else if (cur.length() >= 1 && cur.charAt(cur.length() - 1) != c) 
                dfs(cur +c, n);
        }
    }
}