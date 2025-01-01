class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean [] visited = new boolean[10];
    public List<List<Integer>> subsets(int[] nums) {
        dfs(res, nums, new ArrayList<>(), 0, visited);
        return res;
    }

    public void dfs(List<List<Integer>> res, int [] nums, List<Integer> tmp, 
    int start, boolean [] visited) {
        
        res.add(new ArrayList<>(tmp));

        for(int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                dfs(res, nums, tmp, i + 1, visited);
                tmp.remove(tmp.size() - 1);
        }
    }
}