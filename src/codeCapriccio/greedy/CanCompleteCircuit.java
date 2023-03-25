package codeCapriccio.greedy;

public class CanCompleteCircuit {
    /*
    * 题意（leetcode134. 加油站）：
    *   在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
    *   你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
    *   给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
    * 解题思路：
    *   看代码随想录视频
    */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }


    // 暴力法（超时）
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        int restSum = 0;
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
            restSum += rest[i];
        }
        if(restSum < 0)
            return -1;

        for (int i = 0; i < rest.length; i++) {
            if(rest[i] < 0)
                continue;
            int curRest = rest[i];
            for (int j = (i+1) % rest.length; j != i ; j = (j+1) % rest.length) {
                curRest += rest[j];
                if(curRest < 0)
                    break;
            }
            if(curRest >= 0)
                return i;
        }
        return -1;
    }


}
