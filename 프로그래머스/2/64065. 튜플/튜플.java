import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String [] str = s.split("\\},\\{");
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        
        for(String st : str) {
            String [] arr = st.split(",");
            for(int i = 0; i < arr.length; i++) {
                tmp.add(Integer.parseInt(arr[i]));
            }
            list.add(tmp);
            tmp = new ArrayList<>();
        }
        
        Collections.sort(list, (a,b) -> a.size() - b.size());
        
        Set<Integer> set = new HashSet<>();
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            List<Integer> arrs = list.get(i);
            for(int arr : arrs) {
                if (!set.contains(arr)) {
                    set.add(arr);
                    answer[i] = arr;
                }
            }
        }
    
        return answer;
    }
}