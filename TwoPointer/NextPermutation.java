package TwoPointer;

class Solution {
    public void nextPermutation(int[] nums) {
        int breakPoint = findBreakPoint(nums);
        if (breakPoint >= 0) {
            int indexOfSmallestAfterBreakPoint = findSmallestAfterBreakPoint(nums, breakPoint);
            // swapping
            int temp = nums[indexOfSmallestAfterBreakPoint];
            nums[indexOfSmallestAfterBreakPoint] = nums[breakPoint];
            nums[breakPoint] = temp;
        }
        // reverse
        reverseArray(nums, breakPoint + 1);
    }

    public void reverseArray(int nums[], int left) {
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }

    }

    public int findSmallestAfterBreakPoint (int arr[], int breakPoint) {
        int breakPointValue = arr[breakPoint];
        int smallestValue = Integer.MAX_VALUE, smallestIndex = breakPoint + 1;
        for (int i = breakPoint + 1; i < arr.length; i++) {
            if (arr[i] <= smallestValue && arr[i] > breakPointValue) {
                smallestValue = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public int findBreakPoint(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i-1] < arr[i]) {
                return i-1;
            }
        }
        return -1;
    }
}
