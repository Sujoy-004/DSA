class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(stack.empty() || ch != stack.peek()){
                stack.push(ch);
            }
            else if(ch == stack.peek()){
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}