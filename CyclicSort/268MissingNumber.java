package CyclicSort;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int x : nums) {
            actualSum += x;
        }
        return expectedSum - actualSum;
    }
}
