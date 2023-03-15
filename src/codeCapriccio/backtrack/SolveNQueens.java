package codeCapriccio.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {
    /*
    * 题意（leetcode51. N 皇后）：见leetcode
    * 解题思路：见代码随想录
    */

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for(char[] c: chessboard){
            Arrays.fill(c, '.');
        }
        findPath(chessboard, n, 0);
        return res;
    }

    private void findPath(char[][] chessboard, int n, int row){
        // 如果当前行为n了，表示前n行都有合适位置了，那么收获结果
        if(row == n){
            res.add(Array2List(chessboard));
            return;
        }
        // 单层逻辑
        for (int i = 0; i < n; i++) {
            if(isValid(chessboard, n, row, i)){
                chessboard[row][i] = 'Q';
                findPath(chessboard, n, row+1);
                chessboard[row][i] = '.';
            }
        }
    }

    private List<String> Array2List(char[][] chessboard){
        List<String> list = new ArrayList<>();
        for(char[] c: chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private boolean isValid(char[][] chessboard, int n, int row, int col){
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
