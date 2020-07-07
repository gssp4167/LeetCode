// Medium

// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.

// Note:

// The solution set must not contain duplicate triplets.

// Example:

// Given array nums = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        }
        return res;
}
    
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1])) {
                ++lo;
            }
            else if ( sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            }
            else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
            }
        }
    }
}

// Success
// Details 
// Runtime: 33 ms, faster than 41.84% of Java online submissions for 3Sum.
// Memory Usage: 55.9 MB, less than 16.22% of Java online submissions for 3Sum.
