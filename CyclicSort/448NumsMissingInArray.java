package CyclicSort;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] missing = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            missing[nums[i]] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < missing.length; i++) {
            if (missing[i] == 0) result.add(i);
        }
        return result;
    }
}