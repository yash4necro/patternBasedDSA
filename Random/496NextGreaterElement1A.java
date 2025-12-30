package Random;

import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Array to store the next greater element for each value in nums2
        // Index represents the number, value represents its next greater element
        int[] nextGreater = new int[10001];

        // Stack will store elements from nums2
        // It is maintained as a MONOTONIC DECREASING STACK
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from right to left
        // This helps us find the "next" greater element efficiently
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Debug separator for readability
            // System.out.println("-----------");
            // System.out.println("inside for " + nums2[i]);

            // Remove all elements from the stack that are
            // smaller than or equal to the current element
            // because they cannot be the next greater element
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                // System.out.println("stack is not empty and " + nums2[i] + " > " + stack.peek());
                // System.out.println("pop out " + stack.peek());
                stack.pop();
            }

            // If stack is empty, there is no greater element to the right
            // Otherwise, the top of the stack is the next greater element
            nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element onto the stack
            // It may serve as the next greater element for elements to its left
            // System.out.println("pushing to stack " + nums2[i]);
            stack.push(nums2[i]);
        }

        // Build the answer for nums1 using the precomputed nextGreater array
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }
}
