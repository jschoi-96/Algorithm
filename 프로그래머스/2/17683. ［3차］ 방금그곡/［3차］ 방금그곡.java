import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        
        m = replace(m);
        
        int max_time = 0;
        for(String music : musicinfos) {
            String [] s = music.split(",");
            int st = convert(s[0]);
            int en = convert(s[1]);
            
            int playTime = en - st;
            String title = s[2];
            String melody = replace(s[3]);
            //System.out.println(melody);
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < playTime; i++) {
                sb.append(melody.charAt(i % melody.length()));
            }
            //System.out.println(sb);
            
            if (sb.toString().contains(m)) {
                if (playTime > max_time) { // 길이가 더 길 때, 제목을 갱신해준다.
                    max_time = playTime;
                    answer = title;
                    // playTime == max_time 케이스는 고려하지 않는데 미리 저장된 제목이 먼저 입력됐기 때문 
                }
            }
            
        }
        return answer;
    }
    
    public int convert(String time) {
        String [] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public String replace(String melody){
        return melody
            .replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b");
    }
    
}