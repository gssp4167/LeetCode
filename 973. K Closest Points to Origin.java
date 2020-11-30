// Medium

// We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
// (Here, the distance between two points on a plane is the Euclidean distance.)
// You may return the answer in any order.  
// The answer is guaranteed to be unique (except for the order that it is in.)

// Example 1:
// Input: points = [[1,3],[-2,2]], K = 1
// Output: [[-2,2]]

// Explanation: 
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

// Example 2:
// Input: points = [[3,3],[5,-1],[-2,4]], K = 2
// Output: [[3,3],[-2,4]]
// (The answer [[-2,4],[3,3]] would also be accepted.)
 
// Note:
// 1 <= K <= points.length <= 10000
// -10000 < points[i][0] < 10000
// -10000 < points[i][1] < 10000

// Solution #1 O(nlogn)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len_points = points.length;
        int[] sorted_points = new int[len_points];
        int[][] ans = new int[K][2];
        
        for (int i = 0; i < len_points; ++i) {
            sorted_points[i] = dist(points[i]);
        }
        
        Arrays.sort(sorted_points);
        
        int marker = sorted_points[K - 1];
        int t = 0;
        
        for (int j = 0; j < len_points; ++j) {
            if (dist(points[j]) <= marker) {
                ans[t++] = points[j];
            }
        }
        return ans;
    }
    
    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

// Success
// Details 
// Runtime: 9 ms, faster than 85.25% of Java online submissions for K Closest Points to Origin.
// Memory Usage: 47.4 MB, less than 6.23% of Java online submissions for K Closest Points to Origin.

