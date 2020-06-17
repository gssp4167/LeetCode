# Easy

# Given an array of integers, return indices of the two numbers such that they add up to a specific target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.

# Example:

# Given nums = [2, 7, 11, 15], target = 9,
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i in nums[:-1]:
            i_index = nums.index(i)
            numsp = nums[i_index+1:]
            
            for j in numsp:
                if i + j == target:
                    return [nums.index(i), numsp.index(j)+i_index+1]
                
# Success
# Details 
# Runtime: 5316 ms, faster than 10.85% of Python3 online submissions for Two Sum.

