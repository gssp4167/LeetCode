// Easy

// Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

// Note:

// The length of both num1 and num2 is < 5100.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == "0") {
            return num2;
        }
        
        if (num2 == "0") {
            return num1;
        }
        
        StringBuilder ans = new StringBuilder();
        
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int temp = x1 + x2 + carry;  
            int value = temp % 10;
            carry = temp / 10;      
            ans.append(value);
            --p1;
            --p2;
        }
        
        if (carry > 0) {
            ans.append(carry);
        }
         
        ans.reverse();
        
        return ans.toString();     
    }
}

// Success
// Details 
// Runtime: 2 ms, faster than 91.59% of Java online submissions for Add Strings.
// Memory Usage: 39.5 MB, less than 15.27% of Java online submissions for Add Strings.
