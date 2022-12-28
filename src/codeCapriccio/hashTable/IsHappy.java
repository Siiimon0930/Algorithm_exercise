package codeCapriccio.hashTable;

import java.util.HashSet;
import java.util.Set;

public interface IsHappy {
    /*
    * 题目描述（leetcode202）：编写一个算法来判断一个数 n 是不是快乐数。
    * 解题思路：使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。
    * */
    default boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    default int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
