package OverlappingIntervals;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<int[]>();

        int n1 = newInterval[0], n2 = newInterval[1];
        int i = 0, n = intervals.length;

        // while intervals are before the newInterval
        while (i < n && intervals[i][1] < n1) {
            resultList.add(intervals[i]);
            i++;
        }

        // merging and overlapping intervals
        while (i < n && n2 >= intervals[i][0]) {
            n1 = Math.min(intervals[i][0], n1);
            n2 = Math.max(intervals[i][1], n2);
            i++;
        }
        resultList.add(new int[]{n1, n2});

        // after merging intervals are beyond newInterval
        while (i < n) {
            resultList.add(intervals[i]);
            i++;
        }
        
        return resultList.toArray(new int[resultList.size()][]);
    }
}