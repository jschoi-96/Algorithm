class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // -4,-1,-1,0,1,2
        
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1;

            while (lo < hi) {
                int tmp = nums[i] + nums[lo] + nums[hi];
                if (tmp < 0) lo++;
                else if (tmp > 0) hi--;
                else {
                    set.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++; hi--;
                }
            }
        }
        res.addAll(set);
        return res;
    }
}
