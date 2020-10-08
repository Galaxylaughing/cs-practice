// source: LeetCode
// https://leetcode.com/problems/min-stack

// 155. <easy> Min Stack
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:

    Methods pop, top and getMin operations will always be called on non-empty stacks.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        // add to stack
        stack.addFirst(x);
        // add to minStack if minStack is empty or x < current min
        Integer currMin = minStack.peekFirst();
        if (currMin == null || x <= currMin) {
            minStack.addFirst(x);
        }
    }

    public void pop() {
        // pop off stack
        Integer pop = stack.removeFirst();
        // pop off minStack if item from stack is on top of the minStack
        Integer currMin = minStack.peekFirst();
        if (currMin != null && currMin.equals(pop)) {
            minStack.removeFirst();
        }
    }

    public int top() {
        Integer top = stack.peekFirst();
        return top;
    }

    public int getMin() {
        Integer min = minStack.peekFirst();
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 /*
 18 / 18 test cases passed.
Runtime: 4 ms
Memory Usage: 40.8 MB
 */

