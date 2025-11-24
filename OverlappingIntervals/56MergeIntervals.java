package OverlappingIntervals;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> resultList = new ArrayList<int[]>();
        int u = intervals[0][0];
        int v = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int tempU = intervals[i][0];
            int tempV = intervals[i][1];
            if (v < tempU) {
                resultList.add(new int[] { u, v });
                u = tempU;
                v = tempV;
            } else if (v > tempU && v > tempV) {
                continue;
            } else if (v >= tempU) {
                v = tempV;
            } else {
                u = tempU;
                v = tempV;
            }
        }
        resultList.add(new int[] { u, v });
        int[][] resultArray = resultList.toArray(new int[resultList.size()][]);
        return resultArray;
    }
}
