package codeCapriccio.hashTable;

import java.util.HashSet;
import java.util.Set;

/*
* leetcode202. 快乐数:
* 编写一个算法来判断一个数 n 是不是快乐数。「快乐数」定义为：
*   对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
*   然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
*   如果这个过程 结果为1，那么这个数就是快乐数。
* 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
* 解题思路：无限循环意味着 sum值会重复出现，使用set保存每次的sum，如果重复了则return false
*/
public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 123
        int sum = 0;
        while(n != 1){
            while(n >= 1){
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            // 如果set中已出现过相同sum，return false
            if(set.contains(sum))
                return false;
            set.add(sum);
            n = sum;
            sum = 0;
        }
        return true;
    }
}
