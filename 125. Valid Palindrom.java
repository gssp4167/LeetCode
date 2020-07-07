// Easy

// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// Note: For the purpose of this problem, we define empty string as valid palindrome.

// Example 1:

// Input: "A man, a plan, a canal: Panama"
// Output: true
// Example 2:

// Input: "race a car"
// Output: false

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                builder.append(Character.toLowerCase(ch));
            }
        } 
        
        String filteredString = builder.toString();
        String reversedString = builder.reverse().toString();
        
        return filteredString.equals(reversedString);
    }
}

// Success
// Details 
// Runtime: 6 ms, faster than 40.52% of Java online submissions for Valid Palindrome.
// Memory Usage: 41.4 MB, less than 7.56% of Java online submissions for Valid Palindrome.
