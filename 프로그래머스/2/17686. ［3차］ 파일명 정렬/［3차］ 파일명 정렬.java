import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int n = files.length;
        String [][] arr = new String[n][3]; // [HEAD, NUM, INDEX]
        
        for (int idx = 0; idx < n; idx++) {
            String file = files[idx];
            String head = "";
            String num = "";
            int i = 0;
            
            // HEAD
            while (i < file.length() && !Character.isDigit(file.charAt(i))) {
                head += Character.toUpperCase(file.charAt(i));
                i++;
            }
            
            // NUM (최대 5자리)
            int count = 0;
            while (i < file.length() && Character.isDigit(file.charAt(i)) && count < 5) {
                num += file.charAt(i);
                i++;
                count++;
            }

            arr[idx][0] = head;
            arr[idx][1] = num;
            arr[idx][2] = String.valueOf(idx); // 🔥 고유 인덱스 저장
        }
        
        Arrays.sort(arr, (a, b) -> {
            int headCompare = a[0].compareTo(b[0]);
            if (headCompare != 0) return headCompare;

            int numCompare = Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
            if (numCompare != 0) return numCompare;

            // 🔥 실제 index 비교
            return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
        });

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = Integer.parseInt(arr[i][2]);
            answer[i] = files[originalIndex];
        }

        return answer;
    }
}