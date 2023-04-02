package codeCapriccio.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    /*
    * 题意（leetcode56. 合并区间）：
    *   以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    *   请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
    * 解题思路：根据start排序，然后合并就是了，注意点是合并后区间的新end要是两个区间的end的最大值
    *
    */

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cur = {intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= cur[1]){
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }else{
                res.add(new int[]{cur[0], cur[1]});
                cur[0] = intervals[i][0];
                cur[1] = intervals[i][1];
            }
        }
        res.add(new int[]{cur[0], cur[1]});
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<Integer> cur = new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= cur.get(1)){
                cur.set(1, Math.max(cur.get(1), intervals[i][1])) ;
            }else{
                res.add(new ArrayList<>(cur));
                cur.set(0, intervals[i][0]) ;
                cur.set(1, intervals[i][1]) ;
            }
        }
        res.add(new ArrayList<>(cur));
        return res.stream().map(interval -> interval.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
