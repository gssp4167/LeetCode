# Easy

# Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

# Example:

# Input: [-2,1,-3,4,-1,2,1,-5,4],
# Output: 6
# Explanation: [4,-1,2,1] has the largest sum = 6.

# Follow up:

# If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = float('-inf')
        temp = float('-inf')
        for i in range(len(nums)):
            temp = max(nums[i], temp + nums[i])
            if temp > res:
                res = temp
        return res
        
# Success
# Details 
# Runtime: 104 ms, faster than 18.65% of Python3 online submissions for Maximum Subarray.
# Memory Usage: 14.4 MB, less than 86.64% of Python3 online submissions for Maximum Subarray.
