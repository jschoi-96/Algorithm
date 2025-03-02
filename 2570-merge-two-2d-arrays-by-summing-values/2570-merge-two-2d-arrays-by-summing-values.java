class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int [] nums : nums1) {
            int id = nums[0];
            int val = nums[1];
            map.put(id, val);
        }

        for(int [] nums : nums2) {
            int id = nums[0];
            int val = nums[1];
            if (map.get(id) != null) {
                int original_val = map.get(id);
                map.put(id, original_val + val);
            }
            else map.put(id, val);
        }

        int [][] res = new int[map.size()][2];
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int i = 0; i < keys.size(); i++) {
            res[i][0] = keys.get(i);
            res[i][1] = map.get(keys.get(i));
        }
        
        return res;
    }
}