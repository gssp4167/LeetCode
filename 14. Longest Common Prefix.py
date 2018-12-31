# Easy
# Write a function to find the longest common prefix string amongst an array of strings.

# If there is no common prefix, return an empty string "".

# Example 1:
# Input: ["flower","flow","flight"]
# Output: "fl"

# Example 2:
# Input: ["dog","racecar","car"]
# Output: ""

# Explanation: There is no common prefix among the input strings.

# Note:
# All given inputs are in lowercase letters a-z.

class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if strs == []:
            return ""
        
        else:
            length = len(strs)
            min_length = len(min(strs, key=len))
            ans = ""
    
            for i in range(min_length):
                ans_temp = strs[0][i]
                
                for j in range(length):
                    if ans_temp != strs[j][i]:
                        return ans
    
                ans += ans_temp
    
            return ans
    
# Success
# Details 
# Runtime: 56 ms, faster than 39.90% of Python3 online submissions for Longest Common Prefix.  
