# Easy
# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

# An input string is valid if:

# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Note that an empty string is also considered valid.

# Example 1:
# Input: "()"
# Output: true

# Example 2:
# Input: "()[]{}"
# Output: true

# Example 3:
# Input: "(]"
# Output: false

# Example 4:
# Input: "([)]"
# Output: false

# Example 5:
# Input: "{[]}"
# Output: true

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        lo = list(s)
        li = list(enumerate(lo))
        length = len(lo)
        if length % 2 != 0:
            return False

        while li != []:
            for item in li:
                if item[1] == ')':
                    compare = '('
                    index = item[0] - 1
                    break
                elif item[1] == ']':
                    compare = '['
                    index = item[0] - 1
                    break
                elif item[1] == '}':
                    compare = '{'
                    index = item[0] - 1
                    break
                elif item[0] == len(li)-1:
                    return False

            if li[index][1] != compare:
                return False
            else:
                del lo[index], lo[index]
                li = list(enumerate(lo))

        return True
    
s1 = "()"  #T
s2 = "()[]{}"  #T
s3 = "(]"  #F
s4 = "([)]"  #F
s5 = "{[]}"  #T
s6 = "([]"  #F
s7 = "[([]])"  #F
s8 = "(("  #F
s9 = "()"  #T

print('s1', isValid(s1))
print('s2', isValid(s2))
print('s3', isValid(s3))
print('s4', isValid(s4))
print('s5', isValid(s5))
print('s6', isValid(s6))
print('s7', isValid(s7))
print('s8', isValid(s8))
print('s9', isValid(s9))

# Success
# Details 
# Runtime: 2812 ms, faster than 0.85% of Python online submissions for Valid Parentheses.
