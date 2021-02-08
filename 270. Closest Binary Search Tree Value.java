// Easy

// Given a non-empty binary search tree and a target value, 
// find the value in the BST that is closest to the target.

// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.

// Example:
// Input: root = [4,2,5,1,3], target = 3.714286

//     4
//    / \
//   2   5
//  / \
// 1   3

// Output: 4

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        double diff = Math.abs(target - root.val);
        
        while (root != null) {            
            if (Math.abs(target - root.val) < diff) {
                diff = Math.abs(target - root.val);
                ans = root.val;
            } 
            
            if (diff == 0) {
                return ans;
            }
            else if (target < root.val) {
                root = root.left;
            }
            else {          
                root = root.right;
            }                      
        }
        
        return ans;
    }
}

// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
// Memory Usage: 38.7 MB, less than 76.45% of Java online submissions for Closest Binary Search Tree Value.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;
        
        while (root != null) {
            val = root.val;
            closest = (Math.abs(val - target) < Math.abs(closest - target)) ? val : closest;
            root = (target < val) ? root.left : root.right;
        }
        
        return closest;
    }
}

// Success
// Details 
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
// Memory Usage: 38.8 MB, less than 64.39% of Java online submissions for Closest Binary Search Tree Value.
