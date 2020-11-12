// Medium

// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. 
// The same letter cell may not be used more than once.

// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// Example 3:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 
// Constraints:
// board and word consists only of lowercase and uppercase English letters.
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3

class Solution {
    private char[][] board;
    private int ROW, COL;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROW = board.length;
        this.COL = board[0].length;
        for (int row = 0; row < this.ROW; row++) {
            for (int col = 0; col < this.COL; col++) {
                if (backtrack(row, col, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected boolean backtrack(int row, int col, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row == this.ROW || col < 0 || col == this.COL || this.board[row][col] != word.charAt(index)) {
            return false;
        }
        
        this.board[row][col] = '#';
        
        int[] row_offset = {0, 1, 0, -1};
        int[] col_offset = {1, 0, -1, 0};
        Boolean rslt = false;
        
        for (int d = 0; d < 4; d++) {
            rslt = backtrack(row + row_offset[d], col + col_offset[d], index + 1, word);
            
            if (rslt) break;
        }
        this.board[row][col] = word.charAt(index);
        
        return rslt;
    }
}

// Success
// Details 
// Runtime: 6 ms, faster than 50.40% of Java online submissions for Word Search.
// Memory Usage: 40.4 MB, less than 10.71% of Java online submissions for Word Search.
