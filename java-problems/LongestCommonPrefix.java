// source: LeetCode
// https://leetcode.com/problems/longest-common-prefix/

// 14. <easy> Longest Common Prefix
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

All given inputs are in lowercase letters a-z.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int longestCommonIndex = 0;
        boolean done = false;
        if (strs.length > 1) {
            String firstWord = strs[0];
            // for each letter in firstWord...
            for (int currCharIndex = 0;
                 currCharIndex < firstWord.length() && !done;
                 currCharIndex++) {

                // grab the curr letter in first word
                Character firstWordChar = firstWord.charAt(currCharIndex);

                // check rest of the words
                int currWordIndex = 1;
                while (!done && currWordIndex < strs.length) {
                    String currWord = strs[currWordIndex];

                    if (currCharIndex >= currWord.length()) {
                        // return firstWord.substring(0, longestCommonIndex);
                        done = true;
                    } else {
                        // grab the curr letter in curr word
                        Character currWordChar = currWord.charAt(currCharIndex);

                        // if characters don't match, return longest prefix so far
                        if (!firstWordChar.equals(currWordChar)) {
                            // return firstWord.substring(0, longestCommonIndex);
                            done = true;
                        } else {
                            currWordIndex += 1;
                            // when out of words, reset currWordIndex
                            // increment currCharIndex
                            // and add curr char to longestCommonPrefix
                            if (currWordIndex == strs.length) {
                                longestCommonIndex++;
                            }
                        }
                    }
                }
            }
            return firstWord.substring(0, longestCommonIndex);
        } else if (strs.length == 1) {
            return strs[0];
        }
        return "";
    }
}

/*
118 / 118 test cases passed.
Runtime: 1 ms
Memory Usage: 37.8 MB
*/

