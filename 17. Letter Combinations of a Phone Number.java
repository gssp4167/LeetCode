// Medium

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example:
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.

class Solution {  
    Map<String, String> phone = new HashMap<String, String>() {{
     put("2", "abc");
     put("3", "def");
     put("4", "ghi");
     put("5", "jkl");
     put("6", "mno");
     put("7", "pqrs");
     put("8", "tuv");
     put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();
    
    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        }
        else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) { 
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 87.73% of Java online submissions for Letter Combinations of a Phone Number.
// Memory Usage: 38.1 MB, less than 90.82% of Java online submissions for Letter Combinations of a Phone Number.
