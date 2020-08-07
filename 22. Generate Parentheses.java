// Medium

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
 //  "(())()",
//   "()(())",
//   "()()()"
// ]

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    
    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur);
            return;
        }
        
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 89.18% of Java online submissions for Generate Parentheses.
// Memory Usage: 39.7 MB, less than 22.21% of Java online submissions for Generate Parentheses.
