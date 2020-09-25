# source: LeetCode
# https://leetcode.com/problems/valid-parenthesis-string/

# 678. <medium> Valid Parenthesis String

=begin
 Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    An empty string is also valid.

Example 1:

Input: "()"
Output: True

Example 2:

Input: "(*)"
Output: True

Example 3:

Input: "(*))"
Output: True

Note:

    The string size will be in the range [1, 100].
=end

# @param {String} s
# @return {Boolean}
def check_valid_string(s)
    openStack = []
    wildcardStack = []

    char = 0
    while char < s.length
        if s[char] == '('
            openStack.push(char)
        elsif s[char] == '*'
            wildcardStack.push(char)
        elsif s[char] == ')'
            if !openStack.empty?
                openStack.pop()
            elsif !wildcardStack.empty?
                wildcardStack.pop()
            else
                return false
            end
        end
        char += 1
    end

    if wildcardStack.length < openStack.length
        return false
    else
        position = -1
        while position >= (openStack.length * -1)
            if openStack[position] > wildcardStack[position]
                return false
            end
            position -= 1
        end
    end

    return true
end

=begin
58 / 58 test cases passed.
Runtime: 32 ms
Memory Usage: 9.2 MB
=end

