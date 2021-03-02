package vip.qmwk.leetcode.backtracking;

public class Test_130 {

    /**
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * 示例:
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * 转载请注明出处。
     * @param board
     */
    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // 遍历边界标记
        // 第一行
        for(int i = 0;i<col;i++){
            dfs(board,0,i,row - 1,col - 1);
        }
        // 最后一行
        for(int i = 0;i<col;i++){
            dfs(board,row - 1,i,row - 1,col - 1);
        }
        // 第一列
        for(int i = 0;i<row;i++){
            dfs(board,i,0,row - 1,col - 1);
        }
        // 最后一列
        for(int i = 0;i<row;i++){
            dfs(board,i,col-1,row - 1,col - 1);
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void dfs(char[][] board, int beginRow, int beginCol, int row, int col){
        // 终止条件
        if(beginRow < 0 || beginRow > row || beginCol<0 || beginCol > col){
            return ;
        }
        if(board[beginRow][beginCol] == 'X' || board[beginRow][beginCol] == 'A'){
            return;
        }
        board[beginRow][beginCol] = 'A';
        // 向上
        dfs(board,beginRow - 1,beginCol,row,col);
        // 向下
        dfs(board,beginRow + 1,beginCol,row,col);
        // 向左
        dfs(board,beginRow,beginCol - 1,row,col);
        // 向右
        dfs(board,beginRow,beginCol + 1,row,col);
    }

    public static void main(String[] args) {
        char[][] grid = {{'X','O','X','O','X','O'},
                {'O', 'X', 'O', 'X','O','X'},{'X', 'O','X', 'O', 'X','O'},{'O', 'X','O', 'X', 'O','X'}};
        solve(grid);
        System.out.println(grid);
    }
}
