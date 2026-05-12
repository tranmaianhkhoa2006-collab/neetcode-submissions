class Solution {
    public int op(char op,int num2,int num1){
        switch(op){
            case '+':
               return num1 + num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1/num2;           
        }

        return 0;
    }

    public boolean isDigit(String s){
        if(Character.isDigit(s.charAt(0))){
            return true;
        }
        else if(s.charAt(0)=='-' && s.length()>1){
            return true;
        }

        else return false;
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int begin;

        if(this.isDigit(tokens[0])){
            begin = 0;
        }
        else begin = tokens.length-1;

        if(begin == 0){
           for(int i = begin ; i < tokens.length;i++){
             
             if(this.isDigit(tokens[i])){
                stack.addFirst(Integer.parseInt(tokens[i]));
             }
             else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                int sum = op(tokens[i].charAt(0), num2, num1);
                stack.addFirst(sum);
             }
           }
        }
        else{
            for(int i = begin;i >= tokens.length;i--){
                if(this.isDigit(tokens[i])){
                    stack.addFirst(Integer.parseInt(tokens[i]));
                }
                else{
                    int sum = op(tokens[i].charAt(0), stack.pop(),stack.pop());
                    stack.addFirst(sum);
                }          
            }
        }

        return stack.pop();
    }
}
