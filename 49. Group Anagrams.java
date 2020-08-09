// Medium

// Given an array of strings, group anagrams together.

// Example:
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]

// Note:
// All inputs will be in lowercase.
// The order of your output does not matter.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder("");
            
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
           
            String key = sb.toString();
            
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);    
        }
        return new ArrayList(ans.values());
    }
}

// Success
// Details 
// Runtime: 16 ms, faster than 39.44% of Java online submissions for Group Anagrams.
// Memory Usage: 42.9 MB, less than 63.33% of Java online submissions for Group Anagrams.
