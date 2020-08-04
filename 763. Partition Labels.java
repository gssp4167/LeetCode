// Medium

// A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

// Example 1:
// Input: S = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 
// Note:
// S will have length in range [1, 500].
// S will consist of lowercase English letters ('a' to 'z') only.

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        List<Integer> ans = new ArrayList();
        int anchor = 0, j = 0;
        int n = S.length();
        
        
        for (int i = 0; i < n; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = j + 1;
            }
        }
        return ans;
    }
}

// Success
// Details 
// Runtime: 2 ms, faster than 99.51% of Java online submissions for Partition Labels.
// Memory Usage: 38.3 MB, less than 37.27% of Java online submissions for Partition Labels.
 
