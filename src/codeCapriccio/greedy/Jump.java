package codeCapriccio.greedy;

public class Jump {
    /*
    * 题意（leetcode45. 跳跃游戏 II）：
    *   给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
    *   每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
    *   0 <= j <= nums[i]
    *   i + j < n
    *   返回到达nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
    * 解题思路：
    *   每次跳到区间可跳最右端的位置
    */
    public int jump(int[] nums) {
        // 长度为1时不用跳
        if(nums.length == 1)
            return 0;
        int count = 0;
        int index = 0;
        while(index < nums.length - 1){
            int tempMax = index + nums[index];
            int nextIndex = index;
            // 当前元素可一步跳到尾部时直接跳到尾部，返回count+1
            if(tempMax >= nums.length - 1)
                return count + 1;
            // 当前元素不可一步跳到尾部时，在区间内选取可调达最右端的元素
            for (int i = index; i <= nums[index] + index ; i++) {
                if(nums[i] + i > tempMax){
                    tempMax = nums[i] + i;
                    nextIndex = i;
                }
            }
            index = nextIndex;
            count++;
        }
        return count;
    }
}
