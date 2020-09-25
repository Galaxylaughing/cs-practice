# source: LeetCode
# https://leetcode.com/problems/min-stack/

# 155. <easy> MinStack
=begin
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
=end

class MinStack

    private
    attr_accessor :stack, :min_stack


    public

=begin
    initialize your data structure here.
=end
    def initialize()
        @stack = []
        @min_stack = []
    end


=begin
    :type x: Integer
    :rtype: Void
=end
    def push(x)
        evaluate_min_push(x)
        stack.push(x)
    end


=begin
    :rtype: Void
=end
    def pop()
        evaluate_min_pop()
        stack.pop
    end


=begin
    :rtype: Integer
=end
    def top()
        return stack.last
    end


=begin
    :rtype: Integer
=end
    def get_min()
        return min_stack.last
    end


    private

=begin
    :type x: Integer
    :rtype: Void
=end
    def evaluate_min_push(x)
        current_min = min_stack.last
        if current_min.nil? || x <= current_min
            min_stack.push(x)
        end
    end

=begin
    :rtype: Void
=end
    def evaluate_min_pop()
        last_item = stack.last
        current_min = min_stack.last
        if last_item == current_min
            min_stack.pop
        end
    end

end

# Your MinStack object will be instantiated and called as such:
# obj = MinStack.new()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.get_min()

=begin
18 / 18 test cases passed.
Runtime: 48 ms
Memory Usage: 12.3 MB
=end

