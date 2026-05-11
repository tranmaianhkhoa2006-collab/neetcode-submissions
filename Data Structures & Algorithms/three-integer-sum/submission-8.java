class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> solutionTmp = new HashSet<>();
        List<List<Integer>> solution = new ArrayList<>();
        if(nums.length == 3){
            int sum = 0;
            for(int i=0;i<3;i++){
                sum+=nums[i];
            }

            if(sum != 0)
                return solution;
            else{
                List<Integer> leaf = new ArrayList<>(); 
                for(int i=0;i<3;i++){
                    leaf.add(nums[i]);
                }
                solution.add(leaf);
                return solution;
             
            }    
        }

       
        Arrays.sort(nums);

     
        for(int i=0;i<nums.length-2;i++){
           if (i > 0 && nums[i] == nums[i - 1]) continue;
           int c = nums[i];
           int l = i+1;
           int r = nums.length-1;
          
           while(r-l>=1){
             List<Integer> leaf = new ArrayList<>();
             int sum = c+ nums[l]+nums[r];
             if(sum>0)
                r--;
             else if(sum<0)
                l++;
             else if(sum==0){
                leaf.add(c);
                leaf.add(nums[l]);
                leaf.add(nums[r]);
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
                solution.add(leaf);
             }      
           }
        }

        
        return solution;
    }

}
