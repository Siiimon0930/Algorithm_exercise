package codeCapriccio.array;

public interface MinSubArrayLen {
    // 题目描述（leetcode：209）：求最小子数组长度，要求子数组和大于target，返回子数组长度（存在）或0（不存在）

    /*
    * 解法1：暴力解法
    * 思路：依次从长度为1找到长度length
    * 时间复杂度：O(n^3)
    * 超时！！！
    * */
//    default int minSubArrayLen(int target, int[] nums){
//        for(int len = 1; len <= nums.length; len++){
//            for(int i = 0; i <= nums.length - len; i++){
//                int sum = 0;
//                for(int j = i; j < i + len; j++)
//                    sum += nums[j];
//                if(sum >= target)
//                    return len;
//            }
//        }
//        return 0;
//    }

    /*
    * 解法2：滑动窗口
    * 思路：1）用一个right指针表示子数组终点
    *      2）当外层循环求得子数组和大于等于target时开始移动left指针，取得当前终点位置子数组的真正中最小长度的子数组
    *      3）right走到尾部时即可求得最短子数组
    * 时间复杂度：O(n)
    *
    * 为什么时O(n)?:不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，
    * 每个元素在滑动窗后进来操作一次，出去操作一次，每个元素都是被操作两次，
    * 所以时间复杂度是 2 × n 也就是O(n)。
    * */
    default int minSubArrayLen(int target, int[] nums){
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                int subLen = right - left + 1;
                result = result <= subLen ? result : subLen;
                sum -= nums[left++];
            }
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }
}
