package codeCapriccio.greedy;

import java.util.Arrays;

public class EraseOverlapIntervals {
    /*
    * 题意（leetcode435. 无重叠区间）：
    *   给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
    * 解题思路：
    *   根据end排序，而后再遍历筛选重叠区间
    */

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]){
                count++;
                // 这里取min是因为尽量让保留下来的区间的右边界尽可能的小，从而就可减小后续区间重叠的概率，从而达到一个全局最优
                intervals[i][1] = Math.min(intervals[i-1][1], intervals[i][1]);
            }

        }
        return count;
    }
}
