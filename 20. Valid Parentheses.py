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

def isValid(s):
    """
    :type s: str
    :rtype: bool
    """
    l = list(s)
    length = len(l)
    if length == 1:
        return False
    else:

        while l != []:
            if l[0] == '(':
                compare = ')'
            elif l[0] == '[':
                compare = ']'
            else:
                compare = '}'

            for i in range(1, length, 2):
                if compare == l[i]:
                    del l[0], l[i-1]
                    length = len(l)
                    break
            else:
                return False
        return True

s1 = "()"
s2 = "()[]{}"
s3 = "(]"
s4 = "([)]"
s5 = "{[]}"
s6 = "([]"
s7 = "[([]])"

# print(isValid(s1))
# print(isValid(s2))
# print(isValid(s3))
# print(isValid(s4))
# print(isValid(s5))
# print(isValid(s6))
print(isValid(s7))
