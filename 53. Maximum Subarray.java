// Easy

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

// Follow up:

// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, temp = 0;
        for (int num : nums) {
            temp = Math.max(temp + num, num);
            res = Math.max(temp, res);
        }
        return res;
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 68.85% of Java online submissions for Maximum Subarray.
// Memory Usage: 39.5 MB, less than 53.99% of Java online submissions for Maximum Subarray.
