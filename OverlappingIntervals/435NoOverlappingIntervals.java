package OverlappingIntervals;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int v = intervals[0][1], count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < v) {  // overlap: touching points [1,2],[2,3] are fine
                count++;                // remove current (it has larger end — already sorted)
            } else {
                v = intervals[i][1];    // no overlap, advance the boundary
            }
        }
        return count;
    }
}