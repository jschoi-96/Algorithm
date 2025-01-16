class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        res.addAll(set);
        return res;
    }

    public void dfs(int [] nums, List<Integer> tmp, int idx) {
        set.add(new ArrayList<>(tmp));

        for(int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}