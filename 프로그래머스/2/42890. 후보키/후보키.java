import java.util.*;
class Solution {
    static int n, m;
    static List<Set<Integer>> candidateKeys;
    static String[][] re;
    public int solution(String[][] relation) {
        int answer = 0;
        re = relation;
        
        n = relation.length;
        m = relation[0].length; // 4
        candidateKeys = new ArrayList<>();
        
        for(int i = 1; i <= m; i++) {
            dfs(0, i, 0, new HashSet<>());
        }
        return candidateKeys.size();
    }
    
    public void dfs(int idx, int size, int depth, Set<Integer> set) {
        if (depth == size) {
            
            // 유일성 검사
            if (!unique(set)) return;
            
            // 최소성 검사
            for(Set<Integer> key : candidateKeys) {
                if (set.containsAll(key)) {
                    return;
                }
            }
            candidateKeys.add(set);
            //System.out.println(set);
            return;
        }
        
        for(int i = idx; i < m; i++) {
            Set<Integer> newSet = new HashSet<>(set);
            newSet.add(i);
            dfs(idx + 1, size, depth + 1, newSet);
        }
    }
    
    public boolean unique(Set<Integer> set) {
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int idx : set) {
                sb.append(re[i][idx]);
            }
            
            String s = sb.toString();
            if (!list.contains(s)) {
                list.add(s);
            }
            
            else return false;
        }
        return true;
    }
}