# source: LeetCode
# https://leetcode.com/problems/backspace-string-compare/

# 844. <easy> Backspace String Compare
=begin
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

Follow up:

    Can you solve it in O(N) time and O(1) space?
=end

# @param {String} s
# @param {String} t
# @return {Boolean}
def backspace_compare(s, t)
    s_count = 0
    t_count = 0

    i = s.length - 1
    j = t.length - 1

    while i >= 0 || j >= 0
        if s[i] != "#" && t[j] != "#"
            if s[i] != t[j]
                return false
            else
                i -= 1
                j -= 1
            end
        else
            if i >= 0
                while s[i] == "#" || s_count > 0
                    if s[i] == "#"
                        s_count += 1
                    else
                        s_count -= 1
                    end
                    i -= 1
                end
            end
            if j >= 0
                while t[j] == "#" || t_count > 0
                    if t[j] == "#"
                        t_count += 1
                    else
                        t_count -= 1
                    end
                    j -= 1
                end
            end
        end
    end

    return true
end

=begin
104 / 104 test cases passed.
Runtime: 32 ms
Memory Usage: 9.2 MB
=end

