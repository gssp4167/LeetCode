// Easy

// Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Implement KthLargest class:

// KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
// int add(int val) Returns the element representing the kth largest element in the stream.
 
// Example 1:
// Input
// ["KthLargest", "add", "add", "add", "add", "add"]
// [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output
// [null, 4, 5, 5, 8, 8]

// Explanation
// KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
// kthLargest.add(3);   // return 4
// kthLargest.add(5);   // return 5
// kthLargest.add(10);  // return 5
// kthLargest.add(9);   // return 8
// kthLargest.add(4);   // return 8
 
// Constraints:

// 1 <= k <= 104
// 0 <= nums.length <= 104
// -104 <= nums[i] <= 104
// -104 <= val <= 104
// At most 104 calls will be made to add.
// It is guaranteed that there will be at least k elements in the array when you search for the kth element.

class KthLargest {
    int k;
    List<Integer> nums_arry = new ArrayList();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for (int num : nums) {
            this.nums_arry.add(num);
        }
    }
    
    public int add(int val) {
        this.nums_arry.add(val);
        
        Collections.sort(this.nums_arry, Collections.reverseOrder());
        
        return this.nums_arry.get(this.k - 1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
 
// Success
// Details 
// Runtime: 1532 ms, faster than 5.02% of Java online submissions for Kth Largest Element in a Stream.
// Memory Usage: 46.8 MB, less than 8.41% of Java online submissions for Kth Largest Element in a Stream.
