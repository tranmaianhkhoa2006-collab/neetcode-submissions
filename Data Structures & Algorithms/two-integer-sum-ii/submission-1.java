class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] solution = new int[2];
        int l = 0;
        int r = numbers.length-1;
        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(l<r && sum > target){
                r--;
            }
            else if(l<r && sum < target){
                l++;
            }
            else if(l<r && sum == target){
                solution[0] = l+1;
                solution[1] = r+1;
                break;
            }
        }
        return solution;
    }
}
