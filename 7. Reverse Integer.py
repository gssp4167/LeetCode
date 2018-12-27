# Easy
# Given a 32-bit signed integer, reverse digits of an integer.

# Example 1:
# Input: 123
# Output: 321

# Example 2:
# Input: -123
# Output: -321

# Example 3:
# Input: 120
# Output: 21

# Note:
# Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
# [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

def reverse(x):
    """
    :type x: int
    :rtype: int
    """
    x_abs = abs(x)
    q = x_abs//10
    r = x%10

    if q != 0 and r != 0:
        ans = r 





    if x not in range(-2**31, 2**31-1):
        return 0
