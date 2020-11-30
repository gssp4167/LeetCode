Medium

Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int len = nums.length;
        
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        } 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (n1, n2) -> hm.get(n1) - hm.get(n2)
        );
        
        for (int num : hm.keySet()) {
            pq.offer(num);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}

Success
Details 
Runtime: 11 ms, faster than 39.68% of Java online submissions for Top K Frequent Elements.
Memory Usage: 41.4 MB, less than 78.11% of Java online submissions for Top K Frequent Elements.
