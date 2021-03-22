package vip.qmwk.leetcode.hot100;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class Test_79 {

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        if (row * col < word.length()) {
            return false;
        }
        boolean[][] used = new boolean[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                boolean dfs = dfs(board, word, row, col, used, i, j, 0);
                if(dfs){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, boolean[][] used, int r, int c,  int index) {
        if (index == word.length()) {
            return true;
        }
        if (r >= row || c >= col || r < 0 || c < 0) {
            return false;
        }
        char ch = word.charAt(index);
        if (board[r][c] != ch) {
            return false;
        }
        if (used[r][c]) {
            return false;
        }
        used[r][c] = true;

        boolean result = false;
        // 向上扩展
        boolean dfs1 = dfs(board, word, row, col, used, r - 1, c, index + 1);
        // 向下
        boolean dfs2 = dfs(board,word,row,col,used,r+1,c,index + 1);
        // 向左
        boolean dfs3 = dfs(board,word,row,col,used,r,c-1,index + 1);
        // 向右
        boolean dfs4 = dfs(board,word,row,col,used,r,c+1,index + 1);
        result = dfs1 || dfs2 || dfs3 || dfs4;
        if(result){
            return true;
        }
        used[r][c] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board1 = {{'C','A','A',},{'A','A','A'},{'B','C','D'}};
        char[][] board2 = {{'A'}};
        System.out.println(exist(board2,"A"));
    }
}
