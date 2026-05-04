package CyclicSort;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int [] result = new int[2];
        boolean[] lookup = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (lookup[nums[i]]) {
                result[0] = nums[i];
            } else {
                lookup[nums[i]] = true;
            }
        }
        for (int i = 1; i < lookup.length; i++) {
            if (!lookup[i]) {
                result[1] = i;
            }
        }
        return result;
    }
}