import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 예외 처리: 모두 공집합인 경우
        if (str1.length() == 0 && str2.length() == 0) return 65536;
        
        String tmp1 = "";
        String tmp2 = "";
        for(char c : str1.toCharArray()) tmp1 += Character.toLowerCase(c);
        for(char c : str2.toCharArray()) tmp2 += Character.toLowerCase(c);
        
        // 예외케이스: 두 문자열이 같은 경우 
        if (tmp1.equals(tmp2)) return 65536;
        
        // 1. 두글자씩 끊어서 리스트에 저장
        // 이때, 알파벳만 저장해야하고 숫자, 특수문자는 무시한다
        // 대,소문자 차이는 무시한다
        
        List<String> list1 = divide(str1);
        List<String> list2 = divide(str2);
        
        // for(String list :list2) System.out.println(list);
        
        // 더 길이가 긴 리스트의 원소를 저장한뒤 짧은 리스트를 순회하며 contains
        // 하는 경우에 교집합 값 + 1
        int shareCnt = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String list : list1) map1.put(list, map1.getOrDefault(list, 0) + 1);
        for(String list : list2) map2.put(list, map2.getOrDefault(list, 0) + 1);
        
        //for(String key : map1.keySet()) System.out.println(key + " " + map1.get(key));
        //for(String key : map2.keySet()) System.out.println(key + " " + map2.get(key));
        
        for(String key : map1.keySet()) {
            if (map1.get(key) != null && map2.get(key) != null) {
                shareCnt += Math.min(map1.get(key), map2.get(key));
            }
        }
        
        int sum = list1.size() + list2.size() - shareCnt;
        double rate = (double) shareCnt / sum;
        rate *= 65536;
        return (int) rate;
    }
    
    public List<String> divide(String str) {
        List<String> list = new ArrayList<>();
        String tmp = "";
        for(int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            char prev = str.charAt(i-1);
            
            // 연속으로 문자열이 나온경우에
            if (Character.isAlphabetic(cur) && Character.isAlphabetic(prev)) {
                tmp += Character.toUpperCase(prev);
                tmp += Character.toUpperCase(cur);
                list.add(tmp);
                tmp = "";
            }
        }
        return list;
    }
}