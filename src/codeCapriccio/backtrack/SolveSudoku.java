package codeCapriccio.backtrack;

public class SolveSudoku {
    /*
    * 题意（leetcode37. 解数独）：见力扣
    * 解题思路：二维递归
    *
    */

    // 返回值为Boolean，即表示只需要一个满足条件的结果就可
    public boolean solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != '.')
                    continue;
                for (char k = '1'; k <= '9' ; k++) {
                    if(isValid(board, i, j, k)){
                        board[i][j] = k;
                        if(solveSudoku(board))
                            return true;    // 后续填的数字都满足了就返回true
                        else
                            board[i][j] = '.';  // 此次填的数字无法获得正确结果时回溯
                    }
                }
                return false; // 当9个数字在这个格子都挨个填了仍然无法获得正确结果时表示无解，返回false
            }
            
        }
        return true; // 到此处说明两个for循环中没有‘.’，则棋盘填满了，此时返回true
    }

    private boolean isValid(char[][] board, int row, int col, char num){
        // 判断行
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num)
                return false;
        }

        // 判断列
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == num)
                return false;
        }

        // 判断九宫格
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3 ; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if(board[i][j] == num)
                    return false;
            }
        }
        return true;
    }


}
