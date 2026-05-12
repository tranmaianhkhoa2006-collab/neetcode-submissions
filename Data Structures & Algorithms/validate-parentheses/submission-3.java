class Solution {
    private boolean checker(char s,char t){
        if(Math.abs(s-t) ==2 && s<t)
            return true;

        if(Math.abs(s-t) == 1 && s<t)
            return true;
        return false;        
    }

    private boolean isOpen(char bracket){
       if(bracket == '(' || bracket == '[' || bracket =='{')
         return true;
       return false;         
    }

    private boolean isClosed(char bracket){
       if(bracket == ')' || bracket == ']' || bracket =='}')
         return true;
       return false;         
    }

    public boolean isValid(String s) {
         if(s.length()%2!=0)
            return false;

        Stack<Character> bracket = new Stack<>();

        for(int i = 0;i<s.length();i++){
            if(isOpen(s.charAt(i))){
                bracket.push(s.charAt(i));
            }
            else if(bracket.size()!=0 && isClosed(s.charAt(i))){
                if(!checker(bracket.pop(),s.charAt(i)))
                    return false;
            }
            else return false;
        }

        if(bracket.size()!=0)
            return false;

        return true;
    }
}
