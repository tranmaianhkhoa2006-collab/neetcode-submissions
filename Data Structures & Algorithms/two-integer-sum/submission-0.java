class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if(nums.length == 2){
             int[] earlySolution={0,1};
            return earlySolution;
        } 
       
        HashMap <Integer,Integer> numsHash= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            numsHash.put(nums[i],i);
        }

        int solution[] = new int[2];
        for(int i=0;i<nums.length;i++){
            int difference = target - nums[i];
            if(numsHash.containsKey(difference) && numsHash.get(difference)!=i){
                solution[0]=i;
                solution[1]=numsHash.get(difference);
            }
        }

        Arrays.sort(solution);
        return solution;
    }
}
