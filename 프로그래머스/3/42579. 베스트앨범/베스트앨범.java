import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // 1. 장르 수록
        Map<String, Integer> genreMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 장르 재생 순서가 많은대로 내림차순
        List<String> genreKey = new ArrayList<>(genreMap.keySet()); // keySet 기준으로 내림차순
        genreKey.sort((a,b) -> genreMap.get(b) - genreMap.get(a));
        
        
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        
        for(String genre : genreKey) {
            Map<Integer,Integer> playsMap = new HashMap<>();
            for(int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    playsMap.put(i, plays[i]);
                }
            }
            
            List<Integer> playsList = new ArrayList<>(playsMap.keySet()); // index로 리스트를 만든 후에
            playsList.sort((a,b) -> playsMap.get(b) - playsMap.get(a));
            
                        
            if (playsList.size() == 1) {
                result.add(playsList.get(0));
            }
            
            else {
                 result.add(playsList.get(0));
                 result.add(playsList.get(1));
            }
        }
        
        int [] ans = new int [result.size()];
        for(int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}