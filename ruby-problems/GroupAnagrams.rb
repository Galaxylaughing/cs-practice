# source: LeetCode
# https://leetcode.com/problems/group-anagrams/

# 49. <medium> Group Anagrams

=begin
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]

Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lower-case English letters.
=end

# @param {String[]} strs
# @return {String[][]}
def group_anagrams(strs)
    groups = {}
    strs.each do |word|
        letters_in_word = word.chars.sort().join('')
        if groups[letters_in_word].nil?
            groups[letters_in_word] = [word]
        else
            groups[letters_in_word] << word
        end
    end
    return groups.values
end

=begin
101 / 101 test cases passed.
Runtime: 132 ms
Memory Usage: 12.1 MB
=end

