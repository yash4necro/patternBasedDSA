package SlidingWindow;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int [] s1Arr = new int[26];
        int [] s2Arr = new int[26];

        // Till the length of s1 all chars are added respectively
        // to the counts in both s1Arr and s2Arr
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }

        // 
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            // check if the s1Arr matches s2Arr
            if (matches(s1Arr, s2Arr)) return true;

            // as it didn't match, we move s2Arr window
            // left side of window is restored (as it was incremented earlier)
            s2Arr[s2.charAt(i) - 'a']--;
            // right side of window (extending to length of s1) is incremented
            s2Arr[s2.charAt(i + s1.length()) - 'a']++;
        }
        // out of the loop, we now check the final window
        return matches(s1Arr, s2Arr);
    }
    public boolean matches (int [] s1Arr, int [] s2Arr) {
        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i]) return false;
        }
        return true;
    }
}