Medium

Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

Solution #1
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, len = s.length(), number = 0;
        char operator = '+';
        
        if (s == null || len == 0) {
            return 0;
        }
        
        for (int i = 0; i < len; i++) {
            char cur_char = s.charAt(i);
            
            if (Character.isDigit(cur_char)) {
                number = number * 10 + (cur_char - '0');
            }
            if (!Character.isDigit(cur_char) && !Character.isWhitespace(cur_char) || i == len - 1) {
                if (operator == '+') {
                    stack.push(number);
                }
                else if (operator == '-') {
                    stack.push(-number);
                }
                else if (operator == '*') {
                    stack.push(stack.pop() * number);
                }
                else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                operator = cur_char;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}

Success
Details 
Runtime: 20 ms, faster than 15.33% of Java online submissions for Basic Calculator II.
Memory Usage: 42.1 MB, less than 15.14% of Java online submissions for Basic Calculator II.
