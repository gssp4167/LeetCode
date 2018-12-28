# Easy
# Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

# Example 1:
# Input: 121
# Output: true

# Example 2:
# Input: -121
# Output: false
# Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

# Example 3:
# Input: 10
# Output: false
# Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

# Follow up:
# Could you solve it without converting the integer to a string?

class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        def reverse(x):
            """
            :type x: int
            :rtype: int
            """
            r = x % 10
            q = x // 10
            ans = r

            while q != 0:
                r = q % 10
                q //= 10
                ans = ans * 10 + r

            return ans

        if x < 0:
            return False

        rev = reverse(x)

        if rev == x:
            return True

        else:
            return False
          
# Success
# Details 
# Runtime: 468 ms, faster than 30.29% of Python3 online submissions for Palindrome Number.   
