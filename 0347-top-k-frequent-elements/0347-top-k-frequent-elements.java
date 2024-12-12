class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> tmp = new ArrayList<>();
        for(Integer key : cntMap.keySet()) {
            if (cntMap.get(key) >= k) {
                tmp.add(key);
            }
        }

        List<Integer> keys = new ArrayList<>(cntMap.keySet());

        Collections.sort(keys, (a, b) -> (cntMap.get(b) - cntMap.get(a)));

        int [] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = keys.get(i);
        }
        
        return res;
    }
}