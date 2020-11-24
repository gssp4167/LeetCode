// Easy

// Given a string s and a string t, check if s is subsequence of t.
// A subsequence of a string is a new string which is formed from the original string by deleting some 
// (can be none) of the characters without disturbing the relative positions of the remaining characters. 
// (ie, "ace" is a subsequence of "abcde" while "aec" is not).

// Follow up:
// If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
// and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

// Credits:
// Special thanks to @pbrother for adding this problem and creating all test cases.

// Example 1:
// Input: s = "abc", t = "ahbgdc"
// Output: true

// Example 2:
// Input: s = "axc", t = "ahbgdc"
// Output: false
 
// Constraints:
// 0 <= s.length <= 100
// 0 <= t.length <= 10^4
// Both strings consists only of lowercase characters.

// Solution #1
class Solution {
    public boolean isSubsequence(String s, String t) {
        int ini = 0, s_len = s.length(), t_len = t.length();
        
        for (int i = 0; i < s_len; i++) {
            label: {
                for (int j = ini; j < t_len; j++) {
                    if (t.charAt(j) == s.charAt(i)) {
                        ini = j + 1;
                        break label;
                    }
                }
                return false;
            }
        }
        return true;
    }
}

// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Subsequence.
// Memory Usage: 36.5 MB, less than 99.48% of Java online submissions for Is Subsequence.

// Solution #2
class Solution {
    int s_len, t_len;
    String src, tgt;
    
    private boolean recSubsequence(int s_index, int t_index) {
        if (s_index == s_len) {
            return true;
        }
        
        if (t_index == t_len) {
            return false;
        }
        
        if (src.charAt(s_index) == tgt.charAt(t_index)) {
            s_index++;
            t_index++;
        }
        else {
            t_index++;
        }
        return recSubsequence(s_index, t_index);
    }
    
        
    public boolean isSubsequence(String s, String t) {
        this.s_len = s.length();
        this.t_len = t.length();
        this.src = s;
        this.tgt = t;
        
        return recSubsequence(0, 0);
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 76.36% of Java online submissions for Is Subsequence.
// Memory Usage: 38.5 MB, less than 15.54% of Java online submissions for Is Subsequence.

