package OverlappingIntervals;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int nu = newInterval[0], nv = newInterval[1];
        List<int[]> resultList = new ArrayList<int[]>();
        boolean merged = false;

        for (int i = 0; i < intervals.length; i++) {
            int u = intervals[i][0], v = intervals[i][1];

            if (merged) {
                // If newInterval is already merged, just add all remaining intervals
                resultList.add(new int[] { u, v });
                continue;
            }

            if (nu > u && nv <= v) {
                // newInterval lies fully inside the current interval
                resultList.add(new int[] { u, v });
                merged = true;

            } else if (nu > u && nu > v) {
                // newInterval starts after the current interval (no overlap)
                resultList.add(new int[] { u, v });

            } else if (nu > u && nv > v) {
                // newInterval overlaps current interval on the right,
                // so expand newInterval's start to match current interval's start
                nu = u;

            } else if (nv < u) {
                // newInterval ends before the current interval (no overlap),
                // so we insert newInterval here and then current interval
                resultList.add(new int[] { nu, nv });
                resultList.add(new int[] { u, v });
                merged = true;

            } else if (nv >= u && nv <= v) {
                // newInterval overlaps and ends inside the current interval
                // merge them into one interval
                resultList.add(new int[] { nu, v });
                merged = true;

            } else if (nv > v) {
                // newInterval extends beyond the current interval,
                // so keep checking further intervals
                continue;
            }
        }

        if (!merged) {
            // If newInterval was never inserted or merged, add it at the end
            resultList.add(new int[] { nu, nv });
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}