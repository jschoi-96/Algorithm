주요 접근 방식
1. 어떻게 하면 String을 sort할 수 있을까?
-> `ㅇㅇㅇ`
2. HashMap value를 List형태로 어떻게 담을 수 있을까?



class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            char [] sortStr = str.toCharArray(); 
            Arrays.sort(sortStr);
            String newStr = new String(sortStr);
            
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }

        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
