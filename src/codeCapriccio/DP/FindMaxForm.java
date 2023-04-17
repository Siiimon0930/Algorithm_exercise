package codeCapriccio.DP;

public class FindMaxForm {
    /*
    * 题意（leetcode474. 一和零）：
    *   给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
    *   请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
    *   如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
    * 解题思路：
    *   背包容量是二维的分别为m和n
    */

    public int findMaxForm(String[] strs, int m, int n) {
        // 1.dp数组含义，dp[i][j]表示当前层，0的容量为i，1的容量为j的背包的最大子集长度
        int[][] dp = new int[m+1][n+1];
        // 2.dp数组初始化，都为0
        // 3.递推公式：dp[i][j] = Math.max(dp[i][j], dp[i-x][j-y]+1),+1表示取当前字符串的话子集长度+1
        // 4.遍历顺序：最外层（字符串个数，0-cur），第二层（0的背包容量，i-0），最内层（1的背包容量，j-0）
        for(String str: strs){
            int x = 0, y =0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '0')
                    x++;
                if(str.charAt(i) == '1')
                    y++;
            }
            for (int i = m; i >= x ; i--) {
                for (int j = n; j >= y ; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-x][j-y]+1);
                }
            }
        }
        return dp[m][n];
    }
}
