// Medium

// Given a string s of '(' , ')' and lowercase English characters. 

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
 
// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

// Example 4:
// Input: s = "(a(b(c)d)"
// Output: "a(b(c)d)"
 
// Constraints:
// 1 <= s.length <= 10^5
// s[i] is one of  '(' , ')' and lowercase English letters.

// #1, Using a Stack and String Builder
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                }
                else {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}

// Success
// Details 
// Runtime: 52 ms, faster than 13.52% of Java online submissions for Minimum Remove to Make Valid Parentheses.
// Memory Usage: 52.3 MB, less than 5.08% of Java online submissions for Minimum Remove to Make Valid Parentheses.

// #2 Two Parse String Builde
class Solution {
   private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
       StringBuilder sb = new StringBuilder();
       int balance = 0;
       
       for (int i = 0; i < string.length(); i++) {
           char c = string.charAt(i);
           
           if (c == open) {
               balance++;
           }
           else if (c == close) {
               if (balance == 0) {
                   continue;
               }
               else {
                   balance--;
               }
           }
           sb.append(c);
       }
       return sb;
   }
    
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }
}

// Success
// Details 
// Runtime: 33 ms, faster than 31.19% of Java online submissions for Minimum Remove to Make Valid Parentheses.
// Memory Usage: 47.8 MB, less than 5.08% of Java online submissions for Minimum Remove to Make Valid Parentheses.

// #3Shortened Two Parse String Builder
class Solution {
   public String minRemoveToMakeValid(String s) {
       int openSeen = 0, balance = 0;
       StringBuilder sb = new StringBuilder();
       StringBuilder result = new StringBuilder();
       
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if (c == '(') {
               balance++;
               openSeen++;
           } 
           else if (c == ')') {
               if (balance == 0) {
                   continue;
               }
               else {
                   balance--;
               }
           }
           sb.append(c);
       }
       
       int openToKeep = openSeen - balance;
       
       for (int i = 0; i < sb.length(); i++) {
           char c = sb.charAt(i);
           
           if (c == '(') {
               if (openToKeep == 0) {
                   continue;
               }
               else {
                   openToKeep--;
               }
           }
           result.append(c);        
       }
       return result.toString();
   }
}

// Success
// Details 
// Runtime: 27 ms, faster than 40.99% of Java online submissions for Minimum Remove to Make Valid Parentheses.
// Memory Usage: 48.1 MB, less than 5.08% of Java online submissions for Minimum Remove to Make Valid Parentheses.
