class Solution {
    public String solution(String s) {        
        StringBuilder sb = new StringBuilder();
        String [] arrs = s.split("\\s",-1);
        
        int count = arrs.length - 1;
        int idx = 0;
        for(String arr : arrs) {
            for(int i = 0; i < arr.length(); i++){
                char c = arr.charAt(i);
                if (i % 2 == 0) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
            }
            
            if (idx < arrs.length - 1) {
                sb.append(" ");
                idx++;
            }
        }
        return sb.toString();
    }
}