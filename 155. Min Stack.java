// Easy

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.

// Example 1:
// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]
// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2
 
// Constraints:

// Methods pop, top and getMin operations will always be called on non-empty stacks.

class MinStack {

    /** initialize your data structure here. */
    private Stack<int[]> stack = new Stack<>();
    
    public MinStack() {}
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            // If there's no return, the first element will be stored in the stack twice.
            return;
        }
        
        int crnt_min = stack.peek()[1];
        
        stack.push(new int[]{x, Math.min(x, crnt_min)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
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
 
// Success
// Details 
// Runtime: 4 ms, faster than 92.84% of Java online submissions for Min Stack.
// Memory Usage: 41.2 MB, less than 8.58% of Java online submissions for Min Stack.

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> main_stack = new Stack<>();
    private Stack<int[]> min_stack = new Stack<>();
    
    public MinStack() {}
    
    public void push(int x) {
        main_stack.push(x);
        
        if (min_stack.isEmpty() || x < min_stack.peek()[0]) {
            min_stack.push(new int[]{x, 1});
            return;
        }
        else if (x == min_stack.peek()[0]) {
            min_stack.peek()[1]++;
        }        
    }
    
    public void pop() {
        if (min_stack.peek()[0] == main_stack.peek()) {
            min_stack.peek()[1]--;
            
            if (min_stack.peek()[1] == 0) {
                min_stack.pop();
            }
        }
        main_stack.pop();
    }
    
    public int top() {
        return main_stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek()[0];
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

// Success
// Details 
// Runtime: 4 ms, faster than 92.84% of Java online submissions for Min Stack.
// Memory Usage: 40.8 MB, less than 8.58% of Java online submissions for Min Stack.
