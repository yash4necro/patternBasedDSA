package PrefixSum;

class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int curr = 0, leftSum = 0, rightSum = 0;
        for (int i: nums) {
            rightSum += i;
        }
        rightSum -= nums[curr];
        while (curr < nums.length - 1) {
            if (rightSum != leftSum) {
                leftSum += nums[curr];
                curr++;
                rightSum -= nums[curr];
            }
            if (rightSum == leftSum) {
                return curr;
            }
        }
        return -1;
    }
}
