package codeCapriccio.array;

public interface SpiralMatrix {
    /*
    * 题目描述(Leetcode59)：给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    * 题解思路：用一个[n][n]的矩阵去转圈圈赋值模拟螺旋过程，最终赋值完后的二维矩阵就是结果矩阵
    * 时间复杂度：O（n）
    * */
    default int[][] spiralMatrix(int n){
        int[][] res = new int[n][n];
        int loop = 0;       // 第几次循环计数
        int start = 0;      // 开始坐标值
        int offset = 1;     // 控制终点的偏移量
        int i, j;           // i，j分别表示x，y坐标
        int count = 1;      // 计数的，用此变量给二维数组赋值

        while(loop < n / 2){
            // 遍历上行，区间都是左闭右开
            for(j = start; j < n - offset; j++)
                res[start][j] = count++;
            // 遍历右列
            for(i = start; i < n - offset; i++)
                res[i][j] = count++;
            //遍历下行
            for(; j > start; j--)
                res[i][j] = count++;
            //遍历左列
            for(; i > start; i--)
                res[i][j] = count++;

            loop++;
            start++;
            offset++;
        }

        // 处理n为基数的情况
        if(n % 2 == 1)
            res[n/2][n/2] = count;

        return res;
    }
}
