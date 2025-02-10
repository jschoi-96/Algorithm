class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                char top = stack.peek();
                // 스택의 위가 알파벳이고, 현재 숫자를 가르킬 때
                if (!Character.isDigit(top) && Character.isDigit(c)) {
                    stack.pop();
                }
                else stack.add(c);
            }
            else stack.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}