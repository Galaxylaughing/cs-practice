// source: LeetCode
// https://leetcode.com/problems/merge-sorted-array/

// 88. <easy> Merge Sorted Array
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]



Constraints:

    -10^9 <= nums1[i], nums2[i] <= 10^9
    nums1.length == m + n
    nums2.length == n
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) { return; };

        int finalIndex = (m + n) - 1;
        int i = (m - 1);
        int j = (n - 1);

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[finalIndex] = nums1[i];
                i--;
            } else {
                nums1[finalIndex] = nums2[j];
                j--;
            }
            finalIndex--;
        }

        while (j >= 0) {
            nums1[finalIndex] = nums2[j];
            j--;
            finalIndex--;
        }
    }
}

/*
59 / 59 test cases passed.
Runtime: 0 ms
Memory Usage: 39.7 MB
*/

