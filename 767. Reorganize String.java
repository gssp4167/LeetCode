// Medium

// Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

// If possible, output any possible result.  If not possible, return the empty string.

// Example 1:
// Input: S = "aab"
// Output: "aba"

// Example 2:
// Input: S = "aaab"
// Output: ""
// Note:

// S will consist of lowercase letters and have length in range [1, 500].

// Solution #1
// This method is to sort the cnt array in ascending order and put the most common letter in position 0.
class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        
        int len = S.length();
        int[] cnt = new int[26];
        
        for (char ch : S.toCharArray()) {
            cnt[ch - 'a'] += 100;
        }
        
        for (int i = 0; i < 26; i++) {
            cnt[i] += i;
        }
        
        Arrays.sort(cnt);
        
        for (int i = 0; i < 14; i++) {
            int temp = cnt[i];
            cnt[i] = cnt[25 - i];
            cnt[25 - i] = temp;
        }
        
        int limit = (len + 1) / 2;
        
        if (cnt[0] / 100 > limit) {
                return "";
        }
        
        int t = 0;
        char[] ans = new char[len];
        
        for (int i = 0; i < 26; i++) {
            int letter_cnt = cnt[i] / 100;
            char letter = (char) (cnt[i] % 100 + 'a');
            
            for (int j = 0; j < letter_cnt; j++) {
                if (t >= len) {
                    t = 1;
                }
                
                ans[t] = letter;
                t += 2;
            }
        }
        
        return String.valueOf(ans);
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 83.45% of Java online submissions for Reorganize String.
// Memory Usage: 36.8 MB, less than 98.60% of Java online submissions for Reorganize String.
