package TwoPointer;

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int left = 0, right = tokens.length - 1;
        int score = 0, maxScore = 0;

        while (left <= right) {
            // When we have enough power, play lowest token face-up
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(score, maxScore);
            // We don't have enough power to play a token face-up
            // If there is at least one token remaining,
            // and we have enough score, play highest token face-down
            }
            else if (score >= 1) {
                power += tokens[right];
                score--;
                right--;
            // We don't have enough score, power, or tokens 
            // to play face-up or down and increase our score
            }
            else break;
        }
        return maxScore;
    }
}
