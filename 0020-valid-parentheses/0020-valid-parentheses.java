class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        int n = s.length();
        if(n%2!=0){
            return false;
        }
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')'){
                if(stack.size() == 0){
                    return false;
                }else if(stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            } else if(s.charAt(i) == '}'){
                if(stack.size() == 0){
                    return false;
                }else if(stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            } else if(s.charAt(i) == ']'){
                if(stack.size() == 0){
                    return false;
                }else if(stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }   
        }
        if(stack.size() !=0){
            return false;
        }
        return true;
    }
}