//                          PROBLEM
// Given an array of integers, return indices of the two numbers such that they
// add up to a specific target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.
// Example:
// Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
//
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int check_key_in_map = target - n;
            if (pairs.containsKey(check_key_in_map)) {
                int[] ret = new int[2];
                int index1 = pairs.get(check_key_in_map);
                int index2 = i;
                if (index1 > index2) {
                    ret[0] = index2;
                    ret[1] = index1;
                } else {
                    ret[0] = index1;
                    ret[1] = index2;
                }
                return ret;
            }
            pairs.put(n, i);
        }
        return new int[0];
    }
}