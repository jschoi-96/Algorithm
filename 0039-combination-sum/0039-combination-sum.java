class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }

    public void dfs(int [] candidates, int target, List<Integer> tmp, int cur, int idx) {
        if (cur >= target) {
            if (cur == target) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfs(candidates, target, tmp, cur + candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }
}