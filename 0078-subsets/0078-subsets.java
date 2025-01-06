class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int [] nums, List<Integer> cur, int depth) {
        res.add(new ArrayList<>(cur));

        for(int i = depth; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}