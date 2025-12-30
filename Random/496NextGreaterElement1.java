package Random;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] nextElement = new int[10001];
        
        O: for (int i = 0; i < nums2.length; i++) {
            int j = i + 1;
            while (j <= nums2.length - 1) {
                if (nums2[i] < nums2[j]) {
                    nextElement[nums2[i]] = nums2[j];
                    continue O;
                } else {
                    j++;
                }
            }
            nextElement[nums2[i]] = -1;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextElement[nums1[i]];
        }

        return nums1;
    }
}
