package Random;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];
        int left = 0, right = nums.length - 1, idx = nums.length - 1;
        while (idx >= 0) {
            int left2 = nums[left] * nums[left];
            int right2 = nums[right] * nums[right];
            if (right2 >= left2) {
                result[idx] = right2;
                right--;
                idx--;
            } else {
                result[idx] = left2;
                left++;
                idx--;
            }
        }
        return result;
    }
}
