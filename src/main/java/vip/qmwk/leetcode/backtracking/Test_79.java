package vip.qmwk.leetcode.backtracking;

public class Test_79 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
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
     *
     * @param board
     * @param word
     * @return
     */

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        if (word.length() > row * col) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean dfs = dfs(board, i, j, 0, row - 1, col - 1, word);
                if(dfs){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int beginRow, int beginCol, int depth, int row, int col, String word) {
        if(depth == word.length()){
            return true;
        }
        if (beginRow < 0 || beginRow > row || beginCol < 0 || beginCol > col) {
            return false;
        }
        if (board[beginRow][beginCol] != word.charAt(depth) || board[beginRow][beginCol] == '0') {
            return false;
        }
        char temp = board[beginRow][beginCol];
        board[beginRow][beginCol] = '0';
        // 向上扩展
        boolean dfs1 = dfs(board, beginRow - 1, beginCol, depth + 1, row, col, word);
        // 向下扩展
        boolean dfs2 = dfs(board, beginRow + 1, beginCol, depth + 1, row, col, word);
        // 向左扩展
        boolean dfs3 = dfs(board, beginRow, beginCol - 1, depth + 1, row, col, word);
        // 向右扩展
        boolean dfs4 = dfs(board, beginRow, beginCol + 1, depth + 1, row, col, word);
        if(dfs1 || dfs2 || dfs3 || dfs4){
            return true;
        }else{
            board[beginRow][beginCol] = temp;
            return false;
        }


    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board1 = {{'C','A','A',},{'A','A','A'},{'B','C','D'}};
        System.out.println(exist(board1,"AAB"));
    }
}
