class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    boolean [] visited = new boolean[102];
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, List<Integer> tmp, int idx, int cur) {
        if (cur >= target) {
            if (cur == target) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i-1]) continue;
            tmp.add(candidates[i]);
            dfs(candidates, target, tmp, i + 1, cur + candidates[i]);
            //dfs(candidates, target, tmp, i + 1, cur - candidates[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}