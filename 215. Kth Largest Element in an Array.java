// Medium

// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Example 1:
// Input: [3,2,1,5,6,4] and k = 2
// Output: 5

// Example 2:
// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4

// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.

// Solution #1
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }
}

// Success
// Details 
// Runtime: 1 ms, faster than 98.07% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 39.7 MB, less than 11.26% of Java online submissions for Kth Largest Element in an Array.

// Solution #2
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for (int n : nums) {
            heap.add(n);
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}

// Success
// Details 
// Runtime: 4 ms, faster than 62.71% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 39.4 MB, less than 11.26% of Java online submissions for Kth Largest Element in an Array.
