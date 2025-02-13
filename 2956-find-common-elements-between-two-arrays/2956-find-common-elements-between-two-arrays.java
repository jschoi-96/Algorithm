class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int [] res = new int[2];

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1) set1.add(num);
        for(int num : nums2) set2.add(num);

        int idx1 = 0, idx2 = 0;
        for(int num : nums1) if (set2.contains(num)) idx1++;
        for(int num : nums2) if (set1.contains(num)) idx2++;
        res[0] = idx1;
        res[1] = idx2;
        return res;
    }
}