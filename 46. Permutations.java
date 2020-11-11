// Medium

// Given a collection of distinct integers, return all possible permutations.

// Example:
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> nums_al = new ArrayList();
        
        for (int num : nums) {
             nums_al.add(num);
        }
        
        backtrack(output, nums_al, 0, n);
        
        return output;
    }
    
    public void backtrack(List<List<Integer>> output, ArrayList<Integer> nums, int first, int n){        
        if (first == n) {
            output.add(new ArrayList<Integer>(nums));
        }
        
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(output, nums, first + 1, n);
            Collections.swap(nums, first, i);           
        }
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 91.91% of Java online submissions for Permutations.
// Memory Usage: 39.1 MB, less than 8.63% of Java online submissions for Permutations.
