package PrefixSum;

class Solution {
    public int findMiddleIndex(int[] nums) {
        int preSum [] = new int[nums.length];
        int suffSum [] = new int[nums.length];

        preSum[0] = 0; suffSum[nums.length - 1] = 0;

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }

        for (int i = suffSum.length - 2; i >= 0; i--) {
            suffSum[i] = nums[i + 1] + suffSum[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (suffSum[i] == preSum[i]) return i;
        }
        return -1;
    }
}