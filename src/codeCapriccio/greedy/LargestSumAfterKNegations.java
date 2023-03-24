package codeCapriccio.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestSumAfterKNegations {
    /*
    * 题意（leetcode1005. K 次取反后最大化的数组和）：
    *   给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
    *   选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
    *   重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
    *   以这种方式修改数组后，返回数组 可能的最大和 。
    * 解题思路：
    *   把nums中的负元素都尽可能的变为正的，没有负数时，且k为奇数时则把最小值变为负数，即是最大和的情况，总言之做法是每次取反最小值
    *
    *
    */

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        while(k-- > 0){
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        for(int num : nums)
            sum += num;
        return sum;
    }

    // 提速版
    public int largestSumAfterKNegations2(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }
}
