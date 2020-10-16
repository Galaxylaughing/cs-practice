// source: leetcode

// 1365 <easy> How Many Numbers Are Smaller Than The Current Number
/*
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.


Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]


Constraints:

    2 <= nums.length <= 500
    0 <= nums[i] <= 100
*/

// VERSION 2
import java.util.Arrays;

class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] sortedSmallerCount = new int[nums.length];
        for (int i = 0; i < sorted.length; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                sortedSmallerCount[i] = sortedSmallerCount[i - 1];
            } else {
                sortedSmallerCount[i] = i;
            }
        }

        int[] smallerCount = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // find matching index in the sorted version
            // some of the numbers are duplicated, search won't know which is which
            // but the duplicates have all the same values
            int matchingIndex = Arrays.binarySearch(sorted, nums[i]);
            // copy matching index's value to new array at original index
            smallerCount[i] = sortedSmallerCount[matchingIndex];
        }

        return smallerCount;
    }
}

/*
103 / 103 test cases passed.
Runtime: 2 ms
Memory Usage: 39.2 MB
*/

// VERSION 1
/*
class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smallerCount = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int countSmaller = 0;
            for (int j = 0; j < nums.length; j++) {
                int compareNum = nums[j];
                if (compareNum < currNum) {
                    countSmaller++;
                }
            }
            smallerCount[i] = countSmaller;
        }
        return smallerCount;
    }
}
*/

/*
103 / 103 test cases passed.
Runtime: 11 ms
Memory Usage: 39.2 MB
*/
