class Solution {
    private int max_len = 0;
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        // [2,3,4,5,10,20]
        // [0,1,1,2,3,4,5,6]
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        for(int num : set) { 
            int curLen = 1;
            int curNum = num;
            while(set.contains(curNum + 1)) {
                curNum++;
                curLen++;
            }
            // System.out.println(curLen);
            max_len = Math.max(max_len, curLen);
        }
        return max_len;
    }
}