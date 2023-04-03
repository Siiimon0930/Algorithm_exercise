package codeCapriccio.greedy;

public class MonotoneIncreasingDigits {
    /*
    * 题意（leetcode738. 单调递增的数字）：
    *   当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。
    *   给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 1234 这样每个数字递增表示递增
    * 解题思路：
    *   1.暴力法：从n往前遍历，找第一个满足数字递增的数
    *   2.代码随想录解法
    */

    // 1.暴力法（超出时间限制）
    public int monotoneIncreasingDigits(int n) {
        for (int i = n; i >= 0 ; i--) {
            if(isIncremental(i))
                return i;
        }
        return 0;
    }

    private boolean isIncremental(int num){
        int max = 10;
        while (num != 0) {
            int t = num % 10;
            if (max >= t) max = t;
            else return false;
            num = num / 10;
        }
        return true;
    }


    public int monotoneIncreasingDigits2(int n) {
        String s = String.valueOf(n);
        char[] ss = s.toCharArray();
        int start = ss.length;
        for (int i = ss.length-1; i > 0 ; i--) {
            if(ss[i] < ss[i-1]){
                ss[i-1]--;
                start = i;
                // start[i] = '9' 这里不可这么写，反例100
            }
        }
        for (int i = start; i < ss.length; i++) {
            ss[i] = '9';
        }
        return Integer.valueOf(String.valueOf(ss));
    }
}
