class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = level2(new_id);
        new_id = level3(new_id);
        new_id = level4(new_id);
        new_id = level5(new_id);
        new_id = level6(new_id);
        new_id = level7(new_id);
        
        return new_id;
    }
    
    private String level2(String new_id) {
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()){
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
            
            else {
                continue;
            }
        }
        return sb.toString();
    }
    
    private String level3(String new_id) {
        StringBuilder sb = new StringBuilder();
        boolean lastDot = false;  // 이전 문자가 마침표인지 여부

        for (char c : new_id.toCharArray()) {
            if (c == '.') {
                if (!lastDot) {  // 이전 문자가 마침표가 아닌 경우에만 추가
                    sb.append(c);
                }
                lastDot = true;
            } else {
                sb.append(c);
                lastDot = false;
            }
        }

        return sb.toString();
    }
    
    private String level4 (String new_id) {
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        
        if (new_id.length() >= 1 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        return new_id;
    }
    
    private String level5(String new_id) {
        if (new_id.isEmpty()) {
            new_id += "a";
        }
        return new_id;
    }
    
    private String level6(String new_id) {
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
            
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        return new_id;
    }
    
    private String level7(String new_id) {
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        return new_id;
    }
}