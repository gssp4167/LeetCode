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

// Solution #2
class Solution {
    public boolean isAnagram(String s, String t) {
        int lens = s.length(), lent = t.length();
        
        if (lens != lent) {
            return false;
        }
        
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        
        Arrays.sort(chars);
        Arrays.sort(chart);
        
        return Arrays.equals(chars, chart);
    }
}

// Success
// Details 
// Runtime: 2 ms, faster than 95.16% of Java online submissions for Valid Anagram.
// Memory Usage: 39.1 MB, less than 80.79% of Java online submissions for Valid Anagram.

// Solution #3
class Solution {
    public boolean isAnagram(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        
        if (lens != lent) {
            return false;
        }
        
        int[] arraych = new int[26];

        for (int i = 0; i < lens; i++) {
            arraych[s.charAt(i) - 'a']++;
            arraych[t.charAt(i) - 'a']--;
        }
        
        for (int cnt : arraych) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}

// Success
// Details 
// Runtime: 6 ms, faster than 31.51% of Java online submissions for Valid Anagram.
// Memory Usage: 40.5 MB, less than 5.12% of Java online submissions for Valid Anagram.

// Solution #4
class Solution {
    public boolean isAnagram(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        
        if (lens != lent) {
            return false;
        }
        
        int[] count = new int[26];
        
        for (int i = 0; i < lens; i++) {
            count[s.charAt(i) - 'a']++; 
        }
        
        for (int j = 0; j < lent; j++) {
            count[t.charAt(j) - 'a']--;
            
            if (count[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
            
    }
}

// Success
// Details 
// Runtime: 3 ms, faster than 70.76% of Java online submissions for Valid Anagram.
// Memory Usage: 38.7 MB, less than 99.72% of Java online submissions for Valid Anagram.
