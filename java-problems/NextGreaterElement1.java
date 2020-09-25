// source: LeetCode
// https://leetcode.com/problems/next-greater-element-i/

// 496. <easy> Next Greater Element I
/*
 You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

Note:

    All elements in nums1 and nums2 are unique.
    The length of both nums1 and nums2 would not exceed 1000.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    final Deque<Integer> stack = new ArrayDeque<Integer>();
    final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    final int[] greaterElementList = new int[nums1.length];

    // loop backward over nums2 to fill out map
    for (int i = nums2.length - 1; i >= 0; i--) {
      final int currValue = nums2[i];
      while (!stack.isEmpty() && currValue > stack.peek()) {
        stack.pop();
      }
      map.put(currValue, !stack.isEmpty() ? stack.peek() : -1);
      stack.push(currValue);
    }

    // loop forward over nums1 and add next greater from map to result
    for (int j = 0; j < nums1.length; j++) {
      final int currValue = nums1[j];
      greaterElementList[j] = map.get(currValue);
    }

   return greaterElementList;
  }
}

/*
17 / 17 test cases passed.
Runtime: 3 ms
Memory Usage: 39.5 MB
*/

