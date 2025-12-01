package PrefixSum;

class Solution {
    public int findMiddleIndex(int[] nums) {
        int rightSum = 0;
        for (int i: nums) {
            rightSum += i;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
