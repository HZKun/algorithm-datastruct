package vip.qmwk.leetcode.test;

public class interview_16_04 {


    public static void main(String[] args) {
        String[] input = {"OOX", "XXO", "OX "};
        System.out.println(tictactoe(input));


    }

    public static String tictactoe(String[] board) {
        int n = board.length;
        // 横纵左右对角
        int left = 0;
        int right = 0;
        boolean isFull = true;
        for (int i = 0; i < board.length; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < board[i].length(); j++) {
                row += (int) board[i].charAt(j);
                col += board[j].charAt(i);
                if (String.valueOf(board[i].charAt(j)).equals(" ")) {
                    isFull = false;
                }
            }
            // 斜对角
            left += board[i].charAt(i);
            right += board[i].charAt(n - 1 - i);

            if (row == (int) 'X' * n || col == (int) 'X' * n) {
                return "X";
            }
            if (row == (int) 'O' * n || col == (int) 'O' * n) {
                return "O";
            }
        }
        if (left == (int) 'X' * n || right == (int) 'X' * n) {
            return "X";
        }
        if (left == (int) 'O' * n || right == (int) 'O' * n) {
            return "O";
        }
        if (isFull) {
            return "Draw";
        } else {
            return "Pending";
        }

    }


}
