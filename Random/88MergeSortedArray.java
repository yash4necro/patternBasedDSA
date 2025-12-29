package Random;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int finalArrayIndex = m + n - 1, nums1Index = m - 1, nums2Index = n - 1;
        while (nums2Index >= 0 ) {
            if (nums1Index >= 0 && nums2[nums2Index] < nums1[nums1Index]) {
                nums1[finalArrayIndex] = nums1[nums1Index];
                finalArrayIndex--;
                nums1Index--;
            } else {
                nums1[finalArrayIndex] = nums2[nums2Index];
                finalArrayIndex--;
                nums2Index--;
            }
        }
    }
}
