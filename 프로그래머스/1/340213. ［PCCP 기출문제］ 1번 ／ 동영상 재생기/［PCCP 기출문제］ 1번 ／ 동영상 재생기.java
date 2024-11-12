class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String [] str1 = op_start.split(":");
        String [] str2 = op_end.split(":");
        String [] pos_str = pos.split(":");
        String [] video = video_len.split(":");
        int st = convertInt(str1);
        int en = convertInt(str2);
        //System.out.println(st + " " + en);
        int pos_num = convertInt(pos_str);
        int video_num = convertInt(video);
        //System.out.println("cur: " + pos_num + " video: " + video_num);
        for(String command : commands) {      
            if (pos_num >= st && pos_num <= en) pos_num = en; // 오프닝을 스킵

            if (command.equals("next")) {
                if (video_num - pos_num < 10) pos_num = video_num; // 남은 시간이 10초 미만인 경우
                else pos_num += 10;
            }
            
            else if (command.equals("prev")) {
                if (pos_num < 10) pos_num = 0;
                else pos_num -= 10;
            }

            //System.out.println("cur: " + pos_num);
        }
        if (pos_num >= st && pos_num <= en) pos_num = en; // 오프닝을 스킵

        System.out.println(pos_num);
        
        return convertString(pos_num);
    }
    
    public int convertInt(String [] str) {
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
    
    public String convertString(int num) {
        int div = num / 60;
        int rem = num % 60;
        
        String first = String.valueOf(div);
        if (div < 10) first = "0" + first;
        String second = String.valueOf(rem);
        if (rem < 10) second = "0" + second;
        
        return first + ":" + second;
    }
    
    // 입력값 〉 "30:00", "00:08", "00:00", "00:05", ["prev"]
    // 기댓값 〉 "00:05"
}