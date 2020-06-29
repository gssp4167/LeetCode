// Easy

// Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode"
// return 2.
 
// Note: You may assume the string contains only lowercase English letters.

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

// Success
// Details 
// Runtime: 22 ms, faster than 46.96% of Java online submissions for First Unique Character in a String.
// Memory Usage: 40.2 MB, less than 33.04% of Java online submissions for First Unique Character in a String.
