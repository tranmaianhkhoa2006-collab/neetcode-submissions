class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> checkerHashTable = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            checkerHashTable.add(nums[i]);
        }

        if(checkerHashTable.size()!=nums.length)
            return true;

        return false;    
    }
}