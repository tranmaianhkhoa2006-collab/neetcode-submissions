class MinStack {

    Deque<Integer> minStack = new ArrayDeque<>();
    List<Integer> minValue = new ArrayList<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(minStack.size()==0){
            minValue.add(val);
        }
        else{
            if(minValue.get(minValue.size()-1) >= val){
                 minValue.add(val);
            }
        }
        minStack.addFirst(val);
        
    }
    
    public void pop() {
       if(minStack.size()==0)
         return;

       int popValue = minStack.removeFirst();
     if(minValue.size()!=0){  
       if(popValue == minValue.get(minValue.size()-1))
            minValue.remove(minValue.size()-1);

     }   
    }
    
    public int top() {
       return minStack.peekFirst();
    }
    
    public int getMin() {
        if(minValue.size()!=0)
            return minValue.get(minValue.size()-1);
        return -1;    
    }    
}
