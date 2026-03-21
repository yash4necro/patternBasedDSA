// public class 452MinNoOfArrowsToBurstBalloons {

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort by end coordinate only — greedy sweet spot
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int v = points[0][1]; // current arrow position = end of first balloon

        for (int i = 1; i < points.length; i++) {
            int x0 = points[i][0], x1 = points[i][1];

            if (x0 > v) { // current balloon starts after arrow → need new arrow
                arrows++;
                v = x1; // place new arrow at end of this balloon
            }
            // else: x0 <= v, balloon is hit by current arrow → do nothing
        }

        return arrows;
    }
}
