package vip.qmwk.leetcode.backtracking;

public class Test_200 {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 输入：grid = [
     *      ["1","1","0","0","0"],
     *      ["1","1","0","0","0"],
     *      ["0","0","1","0","0"],
     *      ["0","0","0","1","1"]
     *      ]
     * 输出：3
     * @param grid
     * @return
     */
    private static int count;

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] used = new boolean[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(used[i][j] || grid[i][j] == '0'){
                    continue;
                }
                dfs(grid,used,i,j,row - 1,col - 1);
                count++;
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, boolean[][] used, int beginRow, int beginCol, int row, int col){
        // 终止条件
        if(beginRow < 0 || beginRow > row || beginCol < 0 || beginCol > col){
            return;
        }
        if(used[beginRow][beginCol]){
            return;
        }
        if(grid[beginRow][beginCol] == '0'){
            return;
        }
        used[beginRow][beginCol] = true;
        // 向上扩展
        dfs(grid, used, beginRow-1, beginCol, row, col);
        // 向下扩展
        dfs(grid, used, beginRow+1, beginCol, row, col);
        // 向左扩展
        dfs(grid, used, beginRow, beginCol-1, row, col);
        // 向右扩展
        dfs(grid, used, beginRow, beginCol + 1, row, col);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','1','0'},
                        {'1','1','0','0','1'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        int count = numIslands(grid);
        System.out.println(count);
    }

}
