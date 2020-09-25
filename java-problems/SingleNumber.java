// source: LeetCode
// https://leetcode.com/problems/single-number/

// 136. <easy> Single Number
/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1

Example 2:

Input: [4,1,2,1,2]
Output: 4
*/

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> elements = new HashSet<Integer>();

        // iterate over nums and modify elements
        for (int i = 0; i < nums.length; i++) {
            // is num in elements?
            // if yes, remove from elements
            //  because duplicates will only appear twice
            // if no, add to elements
            Integer currNum = nums[i];
            if (elements.contains(currNum)) {
                elements.remove(currNum);
            } else {
                elements.add(currNum);
            }
        }

        // return remaining element
        // or -1 if no remaining num
        int remainingNum = -1;
        for (Integer element : elements) {
            remainingNum = element;
        }
        return remainingNum;
    }
}

/*
16 / 16 test cases passed.
Runtime: 5 ms
Memory Usage: 39.6 MB
*/

