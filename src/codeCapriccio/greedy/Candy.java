package codeCapriccio.greedy;

public class Candy {
    /*
    * 题意（leetcode135. 分发糖果）：
    *   n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
    *   你需要按照以下要求，给这些孩子分发糖果：
    *   每个孩子至少分配到 1 个糖果。
    *   相邻两个孩子评分更高的孩子会获得更多的糖果。
    *   请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
    * 解题思路：见代码随想录
    */

    public int candy(int[] ratings) {
        int count = 0;
        int[] candies = new int[ratings.length];
        if (candies.length != 0)
            candies[0] = 1;
        // 右>左， 从前往后
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
            else
                candies[i] = 1;
        }
        // 左>右， 从后往前
        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
        }

        for (int i = 0; i < candies.length; i++) {
            count += candies[i];
        }
        return count;
    }
}
