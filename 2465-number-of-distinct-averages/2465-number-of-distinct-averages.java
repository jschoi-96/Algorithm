class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;

        HashSet<Double> set = new HashSet<>();
        while(lo <= hi) {
            int max = nums[hi];
            int min = nums[lo];
            double avg = (min + max) / 2.0;
            System.out.println(avg);
            set.add(avg);
            lo++;
            hi--;
        }
        return set.size();
    }
}