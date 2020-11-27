// Medium

// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
// find the minimum number of conference rooms required.

// Example 1:
// Input: [[0, 30],[5, 10],[15, 20]]
// Output: 2

// Example 2:
// Input: [[7,10],[2,4]]
// Output: 1

// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(final int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        min_heap.add(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= min_heap.peek()) {
                min_heap.poll();
            }        
            min_heap.add(intervals[i][1]);
        }
        return min_heap.size();
    }
}

// Success
// Details 
// Runtime: 8 ms, faster than 18.46% of Java online submissions for Meeting Rooms II.
// Memory Usage: 38.7 MB, less than 84.21% of Java online submissions for Meeting Rooms II.

// Solution #2
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        int room = 1, e_ptr = 0;
        int len = intervals.length;
        int[] s_time = new int[len], e_time = new int[len];
        
        for (int i = 0; i < len; i++) {
            s_time[i] = intervals[i][0];
            e_time[i] = intervals[i][1];
        }        
        
        Arrays.sort(s_time);
        Arrays.sort(e_time);
        
        for (int s_ptr = 1; s_ptr < len; s_ptr++) {
            if (s_time[s_ptr] >= e_time[e_ptr]) {
                e_ptr++;
            }
            else {
                room++;
            }
        }
        return room;
    }
}

// Success
// Details 
// Runtime: 3 ms, faster than 82.18% of Java online submissions for Meeting Rooms II.
// Memory Usage: 41.7 MB, less than 5.06% of Java online submissions for Meeting Rooms II.
