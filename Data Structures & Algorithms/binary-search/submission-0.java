class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        int index = -1;
        while(l!=r){
            int mid = (l+r)/2;

            if(nums[mid] < target){
                l = mid+1;
            }
            else 
                r = mid;
        }

        if(nums[l]==target){
            index = l;
        }

        return index;
    }
}
