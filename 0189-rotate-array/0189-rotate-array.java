class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        int st = n - k;
        if (n - k < 0) st = n - k%n;
        //System.out.println(st);

        int [] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = nums[st % n];
            st++;
        }

        for(int i = 0; i < n; i++) {
            nums[i] = res[i];
            // System.out.print(res[i] + " " );
        }
    }
}