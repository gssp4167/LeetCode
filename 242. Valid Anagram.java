// Easy

// Given two strings s and t , write a function to determine if t is an anagram of s.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?

// Solution #1
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hp = new HashMap<>();
        int lens = s.length(), lent = t.length();
        
        if (lens != lent) {
            return false;
        }
        
        for (char chs : s.toCharArray()) {
            hp.put(chs, hp.getOrDefault(chs, 0) + 1);
        }
        
        for (char cht : t.toCharArray()) {
            if (hp.containsKey(cht)) {
                hp.put(cht, hp.get(cht) - 1);
                
                if (hp.get(cht) < 0) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}

// Success
// Details 
// Runtime: 16 ms, faster than 10.48% of Java online submissions for Valid Anagram.
// Memory Usage: 43.6 MB, less than 5.12% of Java online submissions for Valid Anagram.
