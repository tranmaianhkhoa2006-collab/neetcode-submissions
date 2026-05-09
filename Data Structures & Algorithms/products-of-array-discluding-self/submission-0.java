class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        if(nums.length == 2){
            solution[0]=nums[1];
            solution[1]=nums[0];
            return solution;
        }

        int numberOfZero=0;
       

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                numberOfZero++;
            }
        }




    if(numberOfZero==0){
        int biggestProduct=1;
        for(int i=0;i<nums.length;i++){
            biggestProduct*=nums[i];
        }

        for(int i=0;i<nums.length;i++){
            solution[i]=biggestProduct/nums[i];
        }
    }
    else if(numberOfZero==1){
        int indexOfZero = -1;
        int productOfZeroIndex = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                indexOfZero=i;
        }

        for(int i=0;i<nums.length;i++){
            solution[i]=0;
        }

        for(int i=0;i<nums.length;i++){
           if(i!= indexOfZero) 
                productOfZeroIndex*=nums[i];
        }

        solution[indexOfZero]=productOfZeroIndex;
    }
    else{
        for(int i=0;i<nums.length;i++){
            solution[i]=0;
        }
    }    
    return solution;
        
    }
}  
