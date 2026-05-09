class Solution {
     public int[] productExceptSelf(int[] nums) {
        int solution[] = new int[nums.length];
        solution[0]=1;
        for(int i=1;i<nums.length;i++){
            solution[i]=nums[i-1]*solution[i-1];
        }

        int rightProduct =1;
        for(int i=nums.length-1;i>=0;i--){
            solution[i]*=rightProduct;
            rightProduct*=nums[i];
        }
        return solution;


     }
}  
