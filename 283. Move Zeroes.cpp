// Easy

// Given an array nums, 
// write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:

// 1.You must do this in-place without making a copy of the array.
// 2.Minimize the total number of operations.

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int index_zero = 0;
        int count = 0;
        int nums_size = nums.size();
        
        for (int i = 0; i < nums_size; i++) {
            if (nums[i] != 0) {
                count++;
            } else {
                index_zero = i;
                break;
            }
        } 
        
        for (int i = index_zero + 1; i < nums_size; i++) {
            if (count == nums_size) {
                break;
            } else if (nums[i] != 0) {
                nums[index_zero] = nums[i];
                index_zero++;
                count++;
            }
        }
        
        for (int i = count; i < nums_size; i++) {
            nums[i] = 0;
        } 
    }
};

// Success
// Details 
// Runtime: 12 ms, faster than 96.77% of C++ online submissions for Move Zeroes.
// Memory Usage: 9.5 MB, less than 90.28% of C++ online submissions for Move Zeroes.
