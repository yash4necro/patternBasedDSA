package Random;

class Solution {
    public void moveZeroes(int[] nums) {
        int indx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[indx] = nums[i];
                indx++;
            }
        }
        for(int i = indx; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}