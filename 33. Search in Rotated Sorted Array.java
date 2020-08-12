// Medium

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

// Your algorithm's runtime complexity must be in the order of O(log n).

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (target == nums[mid]) {
                return mid;
            }
            else if (nums[mid] >= nums[start]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
// Memory Usage: 39 MB, less than 85.17% of Java online submissions for Search in Rotated Sorted Array.
