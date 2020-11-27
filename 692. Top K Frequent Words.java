// Medium

// Given a non-empty list of words, return the k most frequent elements.

// Your answer should be sorted by frequency from highest to lowest. 
// If two words have the same frequency, then the word with the lower alphabetical order comes first.

// Example 1:
// Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.

// Example 2:
// Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
// Output: ["the", "is", "sunny", "day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
// Note:
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Input words contain only lowercase letters.

// Follow up:
// Try to solve it in O(n log k) time and O(n) extra space.

// Solution #1
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> word_count = new HashMap<>();
        int len = words.length;
        
        for (String word : words) {
            word_count.put(word, word_count.getOrDefault(word, 0) + 1);
            }
        
        PriorityQueue<String> pq = new PriorityQueue<>(
            (w1, w2) -> word_count.get(w1).equals(word_count.get(w2)) ? w2.compareTo(w1) : word_count.get(w1) - word_count.get(w2));
        
        for (String word : word_count.keySet()) {
            pq.offer(word);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> ans = new ArrayList();
        
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        
        Collections.reverse(ans);
        return ans;
    }
}

// Success
// Details 
// Runtime: 5 ms, faster than 85.78% of Java online submissions for Top K Frequent Words.
// Memory Usage: 39.1 MB, less than 75.68% of Java online submissions for Top K Frequent Words.

// Solution #2
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> word_count = new HashMap<> ();
        
        for (String word : words) {
            word_count.put(word, word_count.getOrDefault(word, 0) + 1);
        }
        
        List<String> candidates = new ArrayList<> (word_count.keySet());
        
        Collections.sort(candidates, (w1, w2) -> word_count.get(w1).equals(word_count.get(w2)) ? w1.compareTo(w2) : word_count.get(w2) - word_count.get(w1));
        
        return candidates.subList(0, k);
    }
}

// Success
// Details 
// Runtime: 10 ms, faster than 5.69% of Java online submissions for Top K Frequent Words.
// Memory Usage: 42.1 MB, less than 5.75% of Java online submissions for Top K Frequent Words.
