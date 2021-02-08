// Easy

// Given a non-negative integer x, compute and return the square root of x.

// Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

// Example 1:
// Input: x = 4
// Output: 2

// Example 2:
// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 
// Constraints:
// 0 <= x <= 231 - 1

class Solution {
    public int mySqrt(int x) {
        long ans = 1;
     
        while (ans * ans <= x) {
            ++ans;
        }
        
        return (int) ans - 1;
    }
}

// Success
// Details 
// Runtime: 18 ms, faster than 7.76% of Java online submissions for Sqrt(x).
// Memory Usage: 36 MB, less than 66.92% of Java online submissions for Sqrt(x).
