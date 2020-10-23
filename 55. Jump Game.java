// Medium

// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
// Constraints:

// 1 <= nums.length <= 3 * 10^4
// 0 <= nums[i][j] <= 10^5

class Solution {
    public boolean canJump(int[] nums) {
        int nums_len = nums.length - 1;
        
        for (int i = nums_len; i >= 0; --i) {
            if (nums[i] + i >= nums_len) {
                nums_len = i;
            }
        }
        return nums_len == 0;
    }
}

// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Jump Game.
// Memory Usage: 41.2 MB, less than 20.81% of Java online submissions for Jump Game.
