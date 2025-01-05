class Solution {
    int res = 0;
    boolean [] visited;
    public int findTargetSumWays(int[] nums, int target) {
        visited = new boolean [nums.length];
        dfs(nums, 0, 0, target);
        return res;
    }

    public void dfs(int [] nums, int depth, int cur, int target) {
        if (depth == nums.length) {
            if (cur == target) {
                res++;
            }
            return;
        }

        dfs(nums, depth + 1, cur + nums[depth], target);
        dfs(nums, depth + 1, cur - nums[depth], target);
    }
}