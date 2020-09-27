// source: Leetcode
// https://leetcode.com/problems/backspace-string-compare

// 844. <easy> Backspace String Compare
/*
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
*/

import java.util.Stack;

class BackspaceStringCompare {
    private Stack makeStack(String S) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {
            Character currChar = S.charAt(i);
            if (currChar == '#' && !stack.empty()) {
                stack.pop();
            } else if (currChar != '#') {
                stack.push(currChar);
            }
        }

        return stack;
    }

    public boolean backspaceCompare(String S, String T) {
        // create stack for each string
        Stack sStack = makeStack(S);
        Stack tStack = makeStack(T);

        // compare contents of stacks
        Character sChar;
        Character tChar;
        while (!sStack.empty() && !tStack.empty()) {
            // pop off both and compare chars
            sChar = (Character) sStack.pop();
            tChar = (Character) tStack.pop();
            if (sChar != tChar) {
                return false;
            }
        }

        // if one stack is empty but the other is not
        // strings are not equal
        if (!sStack.empty() || !tStack.empty()) {
            return false;
        }

        return true;
    }
}

/*
110 / 110 test cases passed.
Runtime: 1 ms
Memory Usage: 37.5 MB
*/

