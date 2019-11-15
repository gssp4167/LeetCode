// Easy

// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: 
// Starting with any positive integer, replace the number by the sum of the squares of its digits, 
// and repeat the process until the number equals 1 (where it will stay), 
// or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 

// Input: 19
// Output: true
// Explanation: 
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1

class Solution {
public:
    int getNext(int n) {
        int totalSum = 0;
        
        while (n > 0) {
            int remainder = n % 10;
            n = n / 10;
            totalSum += remainder * remainder;
        }
        return totalSum;
    }
    
    bool isHappy(int n) {
        unordered_set <int> hashSet;
        
        while (n != 1) { 
            unordered_set <int> :: iterator itr;
            for (itr = hashSet.begin(); itr != hashSet.end(); itr++) {
                if (hashSet.find(n) == itr) {
                    return false;
                }
            }
            
            hashSet.insert(n);
            n = getNext(n);
        }
        
        return true;
    }
};

// Success
// Details 
// Runtime: 4 ms, faster than 67.11% of C++ online submissions for Happy Number.
// Memory Usage: 8.6 MB, less than 57.69% of C++ online submissions for Happy Number.
