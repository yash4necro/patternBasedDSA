package SlidingWindow;

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        long thresholdSum = threshold * k;
        long currSum = 0;
        int result = 0, left = 0, right = k - 1;
        for (int i = left; i < right; i++) {
            currSum += arr[i];
        }
        while (right < arr.length) {
            currSum += arr[right];
            if (currSum >= thresholdSum) result++;
            currSum = currSum - arr[left];
            left++; right++;
        }
        return result;
    }
}
