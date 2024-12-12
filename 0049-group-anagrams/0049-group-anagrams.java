class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }

            map.get(tmp).add(str);
        }

        for(List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}