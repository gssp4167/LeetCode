// Easy

// Given two arrays, write a function to compute their intersection.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.

// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, 
// and the memory is limited such that you cannot load all elements into the memory at once?

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        int num1_len = nums1.length;
        int num2_len = nums2.length;
        
        if (num2_len < num1_len) {
            return intersect(nums2, nums1);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int k = 0;
        
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            
            if (cnt > 0) {
                nums1[k] = num;
                map.put(num, cnt - 1);
                ++k;
            }
        }
        
        return Arrays.copyOf(nums1, k);
        
    }
}

// Success
// Details 
// Runtime: 2 ms, faster than 95.76% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 39.7 MB, less than 18.65% of Java online submissions for Intersection of Two Arrays II.
