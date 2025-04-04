class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean [] visited = new boolean[12];
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        dfs(nums, new ArrayList<>(), 0);
        res.addAll(set);
        return res;
    }

    public void dfs(int [] nums, List<Integer> tmp, int idx) {
        if (tmp.size() == nums.length) {
            set.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(nums[i]);
                dfs(nums, tmp, i);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}