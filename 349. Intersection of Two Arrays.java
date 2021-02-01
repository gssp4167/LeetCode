// Easy

// Given two arrays, write a function to compute their intersection.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]

// Note:
// Each element in the result must be unique.
// The result can be in any order.

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        return intersection(set1, set2);
    }
    
    public int[] intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] ans = new int[set1.size()];
        int i = 0;
        
        for (int num : set1) {
            if (set2.contains(num)) {
                ans[i++] = num;
            }
        }
        
        return Arrays.copyOf(ans, i);
    }
}

// Success
// Details 
// Runtime: 3 ms, faster than 40.92% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 41 MB, less than 6.35% of Java online submissions for Intersection of Two Arrays.
