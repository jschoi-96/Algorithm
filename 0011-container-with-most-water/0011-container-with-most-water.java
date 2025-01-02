class Solution {
    public int maxArea(int[] heights) {
        int lo = 0, hi = heights.length - 1;

        int max_area = 0;
        while(lo < hi) {
            int area = Math.abs(hi - lo) * Math.min(heights[lo], heights[hi]);
            // System.out.println(area);
            max_area = Math.max(area, max_area);
            if (heights[lo] < heights[hi]) {
                lo++;
            }
            else hi--;
        }
        return max_area;
    }
}