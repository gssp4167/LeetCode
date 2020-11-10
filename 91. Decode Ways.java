// Medium

// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given a non-empty string containing only digits, determine the total number of ways to decode it.

// The answer is guaranteed to fit in a 32-bit integer.

// Example 1:
// Input: s = "12"
// Output: 2
// Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// Example 2:
// Input: s = "226"
// Output: 3
// Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

// Example 3:
// Input: s = "0"
// Output: 0
// Explanation: There is no character that is mapped to a number starting with '0'. 
// We cannot ignore a zero when we face it while decoding. 
// So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.

// Example 4:
// Input: s = "1"
// Output: 1
 
// Constraints:

// 1 <= s.length <= 100
// s contains only digits and may contain leading zero(s).

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i < dp.length; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i-1];
            }
            
            int two_pre = Integer.valueOf(s.substring(i-2, i));
            
            if(two_pre >= 10 && two_pre <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 95.03% of Java online submissions for Decode Ways.
// Memory Usage: 37.5 MB, less than 11.87% of Java online submissions for Decode Ways.

class Solution {
    public int numDecodings(String s) {
        int a = 1, len = s.length();
        int b = s.charAt(0) == '0' ? 0 : 1, ans = b;
           
        for (int i = 2; i <= len; ++i) {
            ans = 0;
            
            if (s.charAt(i - 1) != '0') {
                ans += b;     
            }
            
            int two_pre = Integer.valueOf(s.substring(i-2, i));
            
            if(two_pre >= 10 && two_pre <= 26) {
                ans += a;
            }
            
            a = b;
            b = ans;
        }
        return ans;
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 95.03% of Java online submissions for Decode Ways.
// Memory Usage: 37.1 MB, less than 11.87% of Java online submissions for Decode Ways.
